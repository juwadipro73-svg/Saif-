package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [ChatSessionEntity::class, ChatMessageEntity::class, UserAccountEntity::class],
    version = 6,
    exportSchema = false
)
abstract class SaifDatabase : RoomDatabase() {
    abstract fun chatDao(): ChatDao
    abstract fun userAccountDao(): UserAccountDao

    companion object {
        private val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Keep existing chat data on disk, but do not expose it to an unverified
                // account. New sessions are explicitly owned by a Firebase UID.
                db.execSQL("ALTER TABLE chat_sessions ADD COLUMN ownerUid TEXT NOT NULL DEFAULT ''")
            }
        }

        private val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // Additive only: existing accounts, chats and projects are untouched.
                db.execSQL("ALTER TABLE user_accounts ADD COLUMN lastActiveAt INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE user_accounts ADD COLUMN isGuest INTEGER NOT NULL DEFAULT 0")
            }
        }

        @Volatile
        private var INSTANCE: SaifDatabase? = null

        fun getDatabase(context: Context): SaifDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SaifDatabase::class.java,
                    "saif_ai_database_v2"
                )
                    .addMigrations(MIGRATION_4_5, MIGRATION_5_6)
                    .fallbackToDestructiveMigration(dropAllTables = true)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

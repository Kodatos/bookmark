package com.kodatos.shared.platform

import android.content.Context
import com.kodatos.bookmark.db.BookmarkDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class SQLProvider(private val context: Context) {
    actual val driver: SqlDriver by lazy {
        AndroidSqliteDriver(BookmarkDatabase.Schema, context, "bookmark.db")
    }
}
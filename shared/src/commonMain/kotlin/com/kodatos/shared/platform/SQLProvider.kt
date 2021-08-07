package com.kodatos.shared.platform

import com.squareup.sqldelight.db.SqlDriver

expect class SQLProvider {
    val driver: SqlDriver
}
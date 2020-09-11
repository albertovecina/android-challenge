package com.idealista.android.challenge.list.data

import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either
import com.idealista.android.challenge.list.domain.AdList
import com.idealista.android.challenge.list.domain.toDomain

class ListRepository(private val dataSource: ListDataSource) {

    fun list(): Either<CommonError, AdList> = dataSource.list().map { it.toDomain() }

}
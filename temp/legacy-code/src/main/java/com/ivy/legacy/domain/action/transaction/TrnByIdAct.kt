package com.ivy.wallet.domain.action.transaction

import com.ivy.base.legacy.Transaction
import com.ivy.data.db.dao.read.TransactionDao
import com.ivy.frp.action.FPAction
import com.ivy.frp.then
import com.ivy.legacy.datamodel.temp.toLegacyDomain
import java.util.UUID
import javax.inject.Inject

class TrnByIdAct @Inject constructor(
    private val transactionDao: TransactionDao
) : FPAction<UUID, Transaction?>() {
    override suspend fun UUID.compose(): suspend () -> Transaction? = suspend {
        this // transactionId
    } then transactionDao::findById then {
        it?.toLegacyDomain()
    }
}

package com.conymind.backend.model.api

import com.conymind.backend.entity.SuggestQuestionCategoryEntity
import com.conymind.backend.entity.SuggestQuestionEntity

data class CreateRecordRequest(
    val focusQuestionId: Long?,
    val focusQuestionCategoryId: Long?
)
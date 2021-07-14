package com.rana.new_jobs_app_flowredux.data.remote.mappers

import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse
import com.rana.new_jobs_app_flowredux.domain.entities.NewsDomain

fun NewsResponse.toNewsDomain(): NewsDomain? {
    if (status != "ok" || totalResults != 34) return null
    return NewsDomain(
        status = status,
        totalResults = totalResults,
        //conflict in the list name
        articles = List<NewsResponse.Article>())


}


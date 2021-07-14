package com.rana.new_jobs_app_flowredux.data.remote.mappers

import com.rana.new_jobs_app_flowredux.data.remote.entities.NewsResponse.Article
import com.rana.new_jobs_app_flowredux.domain.entities.NewsDomain

fun Article.toNewsDomain(): NewsDomain? {


    return if (this.urlToImage == null) null
    else NewsDomain(
        title = title,
        description = description,
        author = author,
        content = content,
        publishedAt = publishedAt,
        url = url,
        urlToImage = urlToImage
    )

}


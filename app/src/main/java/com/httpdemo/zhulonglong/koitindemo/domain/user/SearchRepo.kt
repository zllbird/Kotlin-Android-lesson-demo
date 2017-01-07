package com.httpdemo.zhulonglong.koitindemo.domain.user

/**
 *
 * Created by zhulonglong on 2017/1/8.
 */

/**
 * {
"total_count": 40,
"incomplete_results": false,
"items": [

]
}
 */
data class SearchRepo(var total_count:Int,var items:List<SearchRepoItem>)

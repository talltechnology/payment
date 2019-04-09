package com.wb.tech.payment

/**
 * Created by WXY on 2019/4/9.
 */
object Api{

        val BaseUrl = "mobile.bwstudent.com/"//正式环境
        val LoginUrl = "movieApi/user/v1/login"//登录
        val RegisterUrl = "user/v1/registerUser"//注册
        val HomeHotUrl = "movie/v1/findHotMovieList"//.查询热门电影列表
        val HomePopularMovieUrl = "movie/v1/findReleaseMovieList"//.查询正在上映电影列表
        val HomeTheFilmHasBeenOnUrl = "movie/v1/findComingSoonMovieList"//.查询即将上映电影列表
        val ParticularsUrl = "movie/v1/findMoviesById"//根据电影ID查询电影信息
        val AttentionUrl = "movie/v1/verify/followMovie"//关注
        val CancelAttentionUrl = "movie/v1/verify/cancelFollowMovie"//取消关注
        val SelecttheatersUrl = "movie/v1/findCinemasListByMovieId"//根据电影ID查询当前排片该电影的影院列表
        val DetailUrl = "movie/v1/findMoviesDetail"//   查看电影详情
        val ScheduleListUrl = "movie/v1/findMovieScheduleList"//  根据电影ID和影院ID查询电影排期列表
        val MovieListByCinemaIdUrl = "movie/v1/findMovieListByCinemaId"//根据影院ID查询该影院当前排期的电影列表

}
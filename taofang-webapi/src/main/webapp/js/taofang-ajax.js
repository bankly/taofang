var ajaxBaseUrl = "http://m.99taofang.com/taofang/webapi";
// var ajaxBaseUrl = "http://localhost:8080/taofang/webapi";
var wxloginUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0f263786638d7cac"
    + "&redirect_uri=http%3a%2f%2fm.99taofang.com%2fviews%2fwxlogin.html"
    + "&response_type=code&scope=snsapi_userinfo&state=99taofang#wechat_redirect";

function getLiangfangList(prescription, order, page, pageSize) {
    var ajaxUrl = ajaxBaseUrl + "/prescription/list?prescription=" + prescription + "&page=" + page + "&pageSize=" + pageSize;
    ajaxUrl += "&order=" + order;
    $.ajax({
        url: ajaxUrl,
        success: processLiangfangPaginationData
    });
}
function getLiangfangDetail(prescriptionId) {
    var ajaxUrl = ajaxBaseUrl + "/prescription/detail/" + prescriptionId;
    $.ajax({
        url: ajaxUrl,
        success: processLiangfangDetailData
    });
}
function getNextLiangfangDetail(prescription, pageId) {
    var ajaxUrl = ajaxBaseUrl + "/prescription/next/detail?prescription=" + prescription + "&pageId=" + pageId;
    $.ajax({
        url: ajaxUrl,
        success: processLiangfangDetailData
    });
}
function getLiangfangComment(prescriptionId) {
    var ajaxUrl = ajaxBaseUrl + "/prescription/comment/" + prescriptionId;
    $.ajax({
        url: ajaxUrl,
        success: processLiangfangCommentData
    });
}
function getLiangfangMaterial(prescriptionId) {
    var ajaxUrl = ajaxBaseUrl + "/prescription/material/" + prescriptionId;
    $.ajax({
        url: ajaxUrl,
        success: processLiangfangMaterialData
    });
}

function getArticlePagination(category, page, pageSize) {
    var ajaxUrl = ajaxBaseUrl + "/article/list/" + category + "?page=" + page + "&pageSize=" + pageSize;
    $.ajax({
        url: ajaxUrl,
        success: processArticlePaginationData
    });
}
function getJKZSPagination(page, pageSize, dateStr){
    var ajaxUrl = ajaxBaseUrl + "/article/list/JKZS?page=" + page + "&pageSize=" + pageSize;
    var notHashDate = typeof(dateStr) == "undefined" || !dateStr || dateStr == "";
    if(!notHashDate){
        ajaxUrl += ("&queryDate=" + dateStr);
    }
    $.ajax({
        url: ajaxUrl,
        success: processArticlePaginationData
    });
}
function getRitucharyaPagination(category, page, pageSize) {
    var ajaxUrl = ajaxBaseUrl + "/article/ritucharya/list/" + category + "?page=" + page + "&pageSize=" + pageSize;
    $.ajax({
        url: ajaxUrl,
        success: processRitucharyaPaginationData
    });
}
function getArticleDetail(category, id) {
    var ajaxUrl = ajaxBaseUrl + "/article/detail/" + id + "?category=" + category;
    $.ajax({
        url: ajaxUrl,
        success: processArticleDetailData
    });
}
function getUserInfo() {
    var userId = $.cookie('userId');
    var ajaxUrl = ajaxBaseUrl + "/user/userinfo/" + userId;
    $.ajax({
        url: ajaxUrl,
        success: processUserInfoData
    });
}
function getUserDetail(module) {
    var userId = $.cookie('userId');
    var ajaxUrl = ajaxBaseUrl + "/user/detail/" + userId + "?module=" + module;
    $.ajax({
        url: ajaxUrl,
        success: processUserDetailData
    });
}
function getUserView() {
    var userId = $.cookie('userId');
    var ajaxUrl = ajaxBaseUrl + "/user/view/" + userId;
    $.ajax({
        url: ajaxUrl,
        success: processUserViewData
    });
}
function getHomeUserView() {
    var userId = $.cookie('userId');
    var isUserView = typeof(userId) == "undefined" || !userId || userId == "";
    if(!isUserView){
        var ajaxUrl = ajaxBaseUrl + "/user/view/" + userId;
        $.ajax({
            url: ajaxUrl,
            success: processHomeUserViewData
        });
    }
}
function getWordStatistics() {
    var ajaxUrl = ajaxBaseUrl + "/word/statistics?pageSize=30&page=1";
    $.ajax({
        url: ajaxUrl,
        success: processWordStatisticsData
    });
}
function getNextJJYSVideo(ritucharya, id) {
    var ajaxUrl = ajaxBaseUrl + "/article/ritucharya/list/video/" + ritucharya + "?lastId=" + id;
    $.ajax({
        url: ajaxUrl,
        success: processNextJJYSVideoData
    });
}
function postUserView(moduleName, clickId, clickTitle) {
    var userId = $.cookie('userId');
    var notPost = typeof(userId) == "undefined" || !userId || userId == "";
    if (!notPost){
        $.ajax({
            timeout: 5000,
            url: ajaxBaseUrl + "/user/view/" + userId,
            contentType: "application/json",
            data: JSON.stringify({userId:parseInt(userId), viewModuleId:0, viewModuleName:moduleName, clickId:clickId, clickTitle:clickTitle}),
            type: "post",
            success: doUserViewData
        });
    }
}
function postUserCollect(userId, clickId, clickTitle) {
    $.ajax({
        timeout: 5000,
        url: ajaxBaseUrl + "/user/collect/" + userId,
        contentType: "application/json",
        data: JSON.stringify({userId:parseInt(userId), viewModuleId:0, viewModuleName:"liangfang", clickId:clickId, clickTitle:clickTitle}),
        type: "post",
        success: doUserCollectData
    });
}
function getArticleThumb(articleId) {
    $.ajax({
        url: ajaxBaseUrl + "/article/thumb/" + articleId,
        success: processArticleThumbData
    });
}
function postArticleThumb(articleId, articleCategory) {
    var userId = $.cookie('userId');
    if(typeof(userId) == "undefined" || !userId || userId == ""){
        userId = "0";
    }
    $.ajax({
        timeout: 5000,
        url: ajaxBaseUrl + "/article/thumb",
        contentType: "application/json",
        data: JSON.stringify({userId:parseInt(userId), articleId:articleId, articleCategory:articleCategory}),
        type: "post",
        success: doArticleThumbData
    });
}
function sendSMSVCode(phoneNumber){
    $.ajax({
        url: ajaxBaseUrl + "/user/sms/" + phoneNumber,
        success: processSMSVCodeData
    });
}
function getAdsByModule(module){
    $.ajax({
        url: ajaxBaseUrl + "/ad/" + module,
        success: processAdvertData
    });
}
function getWeixinShareSignature(){
    $.ajax({
        url: ajaxBaseUrl + "/access/weixin/signature",
        success: initWeixinShare
    });
}

function refreshVCode() {
    $.ajax({
        url: ajaxBaseUrl + "/user/vcode",
        success: doVcodeRefresh
    });
}
// 登录
function login(){
    var errorMessage = checkLoginForm();
    $("#loginregisterErrorMsg").addClass("error").text(errorMessage);
    if(errorMessage == ""){
        var userNameVal = $("#logindiv").find($("[name='userName']")).val();
        var passwordVal = $("#logindiv").find($("[name='password']")).val();
        $.ajax({
            timeout: 5000,
            url: ajaxBaseUrl + "/user/login",
            contentType: "application/json",
            data: JSON.stringify({userName : userNameVal, password : passwordVal}),
            type: "post",
            success: doLoginSuccess
        });
    }
}
// 注册
function register() {
    var errorMessage = checkRegisterForm();
    $("#loginregisterErrorMsg").addClass("error").text(errorMessage);
    if(errorMessage == ""){
        var phoneNumberVal = $("#registerdiv").find($("[name='phoneNumber']")).val();
        var userNameVal = $("#registerdiv").find($("[name='userName']")).val();
        var passwordVal = $("#registerdiv").find($("[name='password']")).val();
        var confirmPasswordVal = $("#registerdiv").find($("[name='confirmPassword']")).val();
        var smsCodeVal = $("#registerdiv").find($("[name='smsCode']")).val();
        $.ajax({
            timeout: 5000,
            url: ajaxBaseUrl + "/user/register",
            contentType: "application/json",
            data: JSON.stringify({phoneNumber:phoneNumberVal, userName:userNameVal, password:passwordVal, confirmPassword:confirmPasswordVal, smsCode:smsCodeVal}),
            type: "post",
            success: doRegisterSuccess
        });
    }
}
// 微信登录
function loginByWX(){
    window.location = wxloginUrl;
}
// QQ登录
function loginByQQ() {

}
function shareArticleDetail() {

}

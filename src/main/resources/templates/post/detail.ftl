<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Fly Template v3.0，基于 layui 的极简社区页面模版</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="/res/layui/css/layui.css">
    <link rel="stylesheet" href="/res/css/global.css">
</head>
<body>

<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="fly-logo" href="/">
            <img src="/res/images/logo.png" alt="layui">
        </a>
        <ul class="layui-nav fly-nav layui-hide-xs">
            <li class="layui-nav-item layui-this">
                <a href="/"><i class="iconfont icon-jiaoliu"></i>交流</a>
            </li>
            <li class="layui-nav-item">
                <a href="../case/case.html"><i class="iconfont icon-iconmingxinganli"></i>案例</a>
            </li>
            <li class="layui-nav-item">
                <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>框架</a>
            </li>
        </ul>

        <ul class="layui-nav fly-nav-user">

            <!-- 登入后的状态 -->
            <li class="layui-nav-item">
                <a class="fly-nav-avatar" href="javascript:;">
                    <cite class="layui-hide-xs">贤心</cite>
                    <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
                    <i class="layui-badge fly-badge-vip layui-hide-xs">VIP3</i>
                    <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="../user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
                    <dd><a href="../user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a>
                    </dd>
                    <dd><a href="../user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a>
                    </dd>
                    <hr style="margin: 5px 0;">
                    <dd><a href="" style="text-align: center;">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>

<div class="layui-hide-xs">
    <div class="fly-panel fly-column">
        <div class="layui-container">
            <ul class="layui-clear">
                <li class="layui-hide-xs"><a href="/">首页</a></li>
                <li class="layui-this"><a href="">提问</a></li>
                <li><a href="">分享<span class="layui-badge-dot"></span></a></li>
                <li><a href="">讨论</a></li>
                <li><a href="">建议</a></li>
                <li><a href="">公告</a></li>
                <li><a href="">动态</a></li>
                <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li>

                <!-- 用户登入后显示 -->
                <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a
                            href="../user/index.html">我发表的贴</a></li>
                <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a
                            href="../user/index.html#collection">我收藏的贴</a></li>
            </ul>

            <div class="fly-column-right layui-hide-xs">
                <span class="fly-search"><i class="layui-icon"></i></span>
                <a href="add.html" class="layui-btn">发表新帖</a>
            </div>
            <div class="layui-hide-sm layui-show-xs-block"
                 style="margin-top: -10px; padding-bottom: 10px; text-align: center;">
                <a href="add.html" class="layui-btn">发表新帖</a>
            </div>
        </div>
    </div>
</div>

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8 content detail">
            <div class="fly-panel detail-box">
                <h1>${post.title}</h1>
                <div class="fly-detail-info">
                    <span class="layui-badge layui-bg-green fly-detail-column">${post.categoryName}</span>

                    <#if post.level gt 0> <span class="layui-badge layui-bg-black">置顶</span></#if>
                    <#if post.recommend> <span class="layui-badge layui-bg-red">精帖</span></#if>

                    <div class="fly-admin-box" data-id="123">
                        <span class="layui-btn layui-btn-xs jie-admin" type="del">删除</span>

                        <span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="1">置顶</span>
                        <!-- <span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="0" style="background-color:#ccc;">取消置顶</span> -->

                        <span class="layui-btn layui-btn-xs jie-admin" type="set" field="status" rank="1">加精</span>
                        <!-- <span class="layui-btn layui-btn-xs jie-admin" type="set" field="status" rank="0" style="background-color:#ccc;">取消加精</span> -->
                    </div>
                    <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i> ${post.commentCount}</a>
            <i class="iconfont" title="人气">&#xe60b;</i> ${post.viewCount}
          </span>
                </div>
                <div class="detail-about">
                    <a class="fly-avatar" href="/user/${post.authorId}">
                        <img src="${post.authorAvatar}"
                             alt="${post.authorName}">
                    </a>
                    <div class="fly-detail-user">
                        <a href="/user/${post.authorId}" class="fly-link">
                            <cite>${post.authorName}</cite>
                        </a>
                        <span>${timeAgo(post.created)}</span>
                    </div>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="post.id">
                        <span class="layui-btn layui-btn-xs jie-admin" type="edit"><a href="add.html">编辑此贴</a></span>
                    </div>
                </div>
                <div class="detail-body photos">
                    ${post.content}
                </div>
            </div>

            <div class="fly-panel detail-box" id="flyReply">
                <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
                    <legend>回帖</legend>
                </fieldset>

                <ul class="jieda" id="jieda">
                    <#list pageData.records as comment>
                        <li data-id="${comment.id}" class="jieda-daan">
                            <a name="item-${comment.id}"></a>
                            <div class="detail-about detail-about-reply">
                                <a class="fly-avatar" href="/user/${post.authorId}">
                                    <img src="${comment.authorAvatar}" alt="${comment.authorName}">
                                </a>
                                <div class="fly-detail-user">
                                    <a href="/user/${comment.authorId}" class="fly-link">
                                        <cite>${comment.authorName}</cite>
                                    </a>

                                    <#if comment.user_id == post.user_id>
                                        <span>(楼主)</span>
                                    </#if>
                                </div>

                                <div class="detail-hits">
                                    <span>${timeAgo(comment.created)}</span>
                                </div>

                            </div>
                            <div class="detail-body jieda-body photos">
                                ${comment.content}
                            </div>
                            <div class="jieda-reply">
                          <span class="jieda-zan zanok" type="zan">
                            <i class="iconfont icon-zan"></i>
                            <em>${comment.voteUp}</em>
                          </span>
                                <span type="reply">
                            <i class="iconfont icon-svgmoban53"></i>
                            回复
                          </span>
                                <div class="jieda-admin">
                                    <span type="del">删除</span>
                                </div>
                            </div>
                        </li>
                    </#list>
                </ul>
                <div style="text-align: center">
                    <div id="laypage-main">

                    </div>
                    <script>
                        layui.use('laypage', function () {
                            var laypage = layui.laypage;

                            //执行一个laypage实例
                            laypage.render({
                                elem: 'laypage-main' //注意，这里的 test1 是 ID，不用加 # 号
                                , count: ${pageData.total} //数据总数，从服务端得到
                                , curr: ${pageData.current} //数据总数，从服务端得到
                                , limit: ${pageData.size} //数据总数，从服务端得到
                                , jump: function (obj, first) {
                                    //obj包含了当前分页的所有参数，比如：
                                    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                                    console.log(obj.limit); //得到每页显示的条数

                                    //首次不执行
                                    if (!first) {
                                        //do something
                                        location.href = "?pn=" + obj.curr;
                                    }
                                }
                            });
                        });
                    </script>
                </div>

                <div class="layui-form layui-form-pane">
                    <form action="/post/reply/" method="post">
                        <div class="layui-form-item layui-form-text">
                            <a name="comment"></a>
                            <div class="layui-input-block">
                                <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <input type="hidden" name="jid" value="${post.id}">
                            <button class="layui-btn" lay-filter="*" lay-submit>提交回复</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <#include "/inc/right.ftl" />
    </div>
</div>

<script src="../../res/layui/layui.js"></script>
<script>
    layui.cache.page = 'jie';
    layui.cache.user = {
        username: '游客'
        , uid: -1
        , avatar: '../../res/images/avatar/00.jpg'
        , experience: 83
        , sex: '男'
    };
    layui.config({
        version: "3.0.0"
        , base: '../../res/mods/'
    }).extend({
        fly: 'index'
    }).use(['fly', 'face'], function () {
        var $ = layui.$
            , fly = layui.fly;
        //如果你是采用模版自带的编辑器，你需要开启以下语句来解析。
        /*
        $('.detail-body').each(function(){
          var othis = $(this), html = othis.html();
          othis.html(fly.content(html));
        });
        */
    });
</script>

</body>
</html>

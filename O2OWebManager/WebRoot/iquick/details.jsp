<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh_CN">
 <head>
   		<meta charset="utf-8">
   		<meta http-equiv="Pragma" CONTENT="no-cache">
		<meta http-equiv="Expires" CONTENT="-1">
   		
   		<title>i&middot;quick--i快客</title>
   		<meta name="keywords" content="I&middot;快客" />
   		<meta name="description" content="I&middot;快客" />
		<meta name="robots" content="all" />
		
		<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">

		<link href="assets/css/basic.css" rel="stylesheet" type="text/css" />
		
		<link rel="stylesheet" type="text/css" href="assets/css/details.css" /> 
  		<link rel="stylesheet" type="text/css" href="assets/js/clib/toastr/toastr.css" /> 

		<script src="assets/js/sea.js" type="text/javascript"></script> 
		<script src="assets/js/jquery-1.11.1.js" type="text/javascript"></script>
		<script type="text/javascript">
			// IQuick global object
			window.IQ = {};
		</script>
		
		<!--[if lt IE 9]>
		  <script src="assets/js/html5shiv.js"></script>
		<![endif]-->
	</head>
  	<body>




   <div id="top"> 
  <div id="top_head"> 
    <strong>您好！欢迎来到I&middot;快客，祝您购物愉快！</strong> 
    <p><a target="_blank" href="/login">登陆</a><span>|</span><a target="_blank" href="/regist">注册</a><span>|</span><a target="_blank" href="/mine">我的I&middot;快客</a><span>|</span><a target="_blank" href="/collect">我的收藏</a><span>|</span><a target="_blank" href="/cart">我的购物车</a><span>|</span><a target="_blank" href="/cart">去付款</a></p> 
  </div> 
</div>

  <div id="container"> 
   <!--Top begin--> 
   <div id="head" class="cf"> 
    <div id="top_ad">
     <img src="/O2OWebManager/iquick/assets/images/ad1.png" alt="" />
    </div> 
    
    <div id="top_center" class="cf"> 
     <div id="top_logo">
      <img src="/O2OWebManager/iquick/assets/images/logo_1.png" alt="" />
     </div> 
     <div id="top_serch"> 
      <form action="#" method="get" class="search_form"> 
       <input type="text" name="s" class="sinput" placeholder="输入 回车搜索" autofocus="" x-webkit-speech="" /> 
       <input type="submit" value="搜索" class="sbtn" /> 
      </form> 
     </div> 
    </div> 
    <!--顶部导航BEGIN--> 
    <div id="top_navi"> 
     <div class="nav-wrap"> 
      <div class="nav"> 
       <div class="goods"> 
        <div> 
         <h2> <a>全部商品分类</a> </h2> 
        </div>
        <div class="all-goods" data-src="#" data-template-sub="#t-categories" data-template-item="#t-category-item"> 
        </div>
       </div> 
       <ul class="nav-list cf"> 
        <li> <a href="#" class="on">首页</a> </li> 
        <li><a href="#">上门洗衣</a></li> 
        <li><a href="#">宠物服务</a></li> 
        <li><a href="#">送花服务</a></li> 
        <li><a href="#">水电燃代缴</a></li> 
        <li><a href="#">汽车租赁与保养</a></li> 
        <li><a href="#">家政保洁</a></li> 
       </ul> 
      </div> 
     </div> 
    </div> 
    <!--顶部导航END--> 

   </div> 
   <!--Top end--> 
   <!--content begin--> 
   <div id="content" class="cf"> 
    <div id="mid" class="cf"> 
     <div id="mid_left"> 
      <div class="head-pic"> 
       <div class="big-pic" id="showCon0"> 
        <a href="#"><img alt="" src="/O2OWebManager/iquick/assets/images/product.png" /></a>
       </div> 
       <div class="pro_s"> 
        <ul class="small-pic"> 
         <li class="on" id="list0" onmouseover="showContent(0)"> <a><img src="/O2OWebManager/iquick/assets/images/product_s.png" /></a> </li> 
        </ul> 
       </div> 
      </div> 
     </div> 
     <div id="mid_mid"> 
      正在加载
     </div> 
     <div id="mid_right"> 
      <div class="rexiao"> 
       <p>———— 热销推荐 ————</p> 
      </div> 
      <div class="r_box"> 
       <ul> 
        <li class="r_pro"><a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/product_r.png" width="170" height="170" /></a></li> 
        <li class="r_pro_d"><a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/product_r.png" width="170" height="170" /></a></li> 
       </ul> 
      </div> 
      <div class="r_box_button"> 
       <div class="r_b_p">
        <a href="#"><img src="/O2OWebManager/iquick/assets/images/prev.png" /></a>
       </div> 
       <div class="r_b_n">
        <a href="#"><img src="/O2OWebManager/iquick/assets/images/next.png" /></a>
       </div> 
      </div> 
     </div> 
    </div> 
    <div id="bottom" class="cf"> 
     <div id="bottom_l"> 
      <div class="tab1" id="tab1"> 
       <div class="menu"> 
        <ul> 
         <li id="one1" onclick="setTab('one',1)">商品分类</li> 
         <li id="one2" onclick="setTab('one',2)">热门推荐</li> 
        </ul> 
       </div> 
       <div class="menudiv"> 
        <div id="con_one_1"> 
         <ul class="navi_l"> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
          <li><h1><a href="#" target="_blank">&gt;&nbsp;商品名称</a></h1></li> 
         </ul> 
        </div> 
        <div id="con_one_2" style="display:none;"></div> 
        <hr style="border-top:1px dashed #898989; border-bottom:none; height:1px; overflow:hidden;" /> 
        <br /> 
        <p>看过本商品的用户还看过</p> 
        <div id="look"> 
         <div id="look_pro"> 
          <a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/product_s.png" /></a> 
          <p><a target="_blank" href="#">妙妙 鸡味香脆片 60g 马来西亚进口</a></p> 
          <b>&yen;11.9</b>
          <br /> 
          <input type="button" class="cart_button" value="加入购物车" /> 
         </div> 
         <div id="look_pro"> 
          <a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/product_s.png" /></a> 
          <p><a target="_blank" href="#">妙妙 鸡味香脆片 60g 马来西亚进口</a></p> 
          <b>&yen;11.9</b>
          <br /> 
          <input type="button" class="cart_button" value="加入购物车" /> 
         </div> 
         <div id="look_pro"> 
          <a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/product_s.png" /></a> 
          <p><a target="_blank" href="#">妙妙 鸡味香脆片 60g 马来西亚进口</a></p> 
          <b>&yen;11.9</b>
          <br /> 
          <input type="button" class="cart_button" value="加入购物车" /> 
         </div> 
        </div> 
       </div> 
      </div> 
      <div id="bottom_l_b"> 
       <div class="bottom_l_bt"> 
        <h3>热销排行</h3> 
       </div> 
       <div class="bottom_l_bb"> 
        <ul> 
         <li class="pro_1"><a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/pro_b.png" width="85" height="85" alt="" /></a><a target="_blank" href="#">【无添加】樱の季节 杏仁粉 新鲜无糖 200g/罐</a><p>&yen;179</p></li> 
         <li><span>&nbsp;2&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;3&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;4&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;5&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;6&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;7&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;8&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>&nbsp;9&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
         <li><span>10&nbsp;</span><a target="_blank" href="#">hahne 亨利 玉米片 375g 德国进口</a></li> 
        </ul> 
       </div> 
      </div> 
     </div> 
     <div id="wrapper"> 
      <div class="bbox demo2"> 
       <ul class="tab_menu"> 
        <li class="current">商品详情</li> 
        <li>评价</li> 
        <li>相关商品</li> 
       </ul> 
       <div class="tab_box"> 
        <div id="description"> 
         <ul> 
          <p>规格参数</p> 
         </ul> 
        </div> 
        <div class="hide"> 
         <ul> 
         </ul> 
        </div> 
        <div class="hide"> 
         <ul> 
         </ul> 
        </div> 
        <div class="hide"> 
         <ul> 
         </ul> 
        </div> 
       </div> 
       <div class="pro_des"> 
       </div> 
      </div> 
     </div> 
    </div> 
    <!--content end--> 
   </div> 
  </div>

  <script type="text/javascript" src="/O2OWebManager/iquick/assets/js/~js/focus.js"></script> 
  <script type="text/javascript" src="/O2OWebManager/iquick/assets/js/~js/jquery.tabs.js"></script> 
  <script type="text/javascript" src="/O2OWebManager/iquick/assets/js/~js/jquery.lazyload.js"></script> 
  <script type="text/javascript" src="/O2OWebManager/iquick/assets/js/~js/lanrenzhijia.js"></script> 
  <script>
    function setTab(name,cursel){
      cursel_0=cursel;
      for(var i=1; i<=links_len; i++){
        var menu = document.getElementById(name+i);
        var menudiv = document.getElementById("con_"+name+"_"+i);
        if(i==cursel){
          menu.className="off";
          menudiv.style.display="block";
        }
        else{
          menu.className="";
          menudiv.style.display="none";
        }
      }
    }
    function Next(){                                                        
      cursel_0++;
      if (cursel_0>links_len)cursel_0=1
      setTab(name_0,cursel_0);
    } 
    var name_0='one';
    var cursel_0=1;//循环周期，可任意更改（毫秒）
    var links_len,iIntervalId;
    var ScrollTime = 10000;

    $(function(){
        var links = $('#tab1 .menu li');
        links_len=links.length;
        for(var i=0; i<links_len; i++){
          links[i].onmouseover=function(){
            clearInterval(iIntervalId);
            this.onmouseout=function(){
              iIntervalId = setInterval(Next,ScrollTime);;
            }
          }
        }

        document.getElementById("con_"+name_0+"_"+links_len).parentNode.onmouseover=function(){
          clearInterval(iIntervalId);
          this.onmouseout=function(){
            iIntervalId = setInterval(Next,ScrollTime);;
          }
        }
        setTab(name_0,cursel_0);
        iIntervalId = setInterval(Next,ScrollTime);
    });
  </script>


  <!-- by daidai.in -->
  <script type="text/template" id="t-detail-midl" data-target="#mid_left">
    <div class="head-pic">
  <div class="big-pic" id="showCon9999"> 
   <a href="#"><img alt="" src="/O2OWebManager/image/getImage?imageID=<{= item.imageId }>" /></a>
  </div>
  <{ 
    var i = 0, len = images.length;
    for(i;i<len;i++){
  }>
 <div class="big-pic" id="showCon<{= i }>" style="display:none"> 
  <a href="#"><img alt=""src="/O2OWebManager/image/getImage?imageID=<{= images[i] }>" /></a>
 </div>
 <{ }}> 
 <div class="pro_s"> 
  <ul class="small-pic"> 
    <li class="on" id="list9999" onmouseover="showContent(9999)"><a>
      <img src="/O2OWebManager/image/getImage?imageID=<{= item.imageId }>" /></a>
    </li> 
    <{ 
      i = 0;
      for(i;i<len;i++){
    }>
    <li id="list<{= i }>" onmouseover="showContent(<{= i }>)"><a>
      <img src="/O2OWebManager/image/getImage?imageID=<{= images[i] }>" /></a>
    </li> 
   <{ }}>
  </ul> 
 </div> 
</div> 

  </script>

  <script type="text/template" id="t-detail-midm" data-target="#mid_mid">
    
      <div class="cf"> 
       <strong><{= itemName }></strong> 
       <br />
       <b class="subt">东南亚 进口休闲食品 下午茶点心 啤酒搭档 膨化 </b> 
       <hr style="border-top:1px dashed #898989; border-bottom:none; height:1px; overflow:hidden;" /> 
       <b>价格</b>&nbsp;
       <b class="base-price">
        &yen;<{= price }>
       </b> 
       <br />
       <b>促销</b>&nbsp;
       <b class="spec">
        今日特卖
       </b>&nbsp;
       <b class="sale-price">
        &yen;<{= price }>
       </b>
       <br /> 
       <div class="hui cf"> 
        <div class="youhui">
         <a target="_blank" href="#" style="margin-right:34px;">历史新低</a>
         <a id="collect-btn" href="javascript:;">收藏</a>
        </div> 
        <div class="jifen">
         <a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/jifen.png" alt="" /></a>
        </div> 
       </div> 
       <b class="send">
        可送货至乌市 沙依巴克区 新市区 天山区 水磨沟区 米东区
       </b>
       <br /> 
       <b>
        商家承诺订购货品1小时内送货到达！
       </b> 
      </div> 
      <div id="fbox" class="cf"> 
       <form> 
        <a class="count-btn" id="sub" data-mix="-1">-</a>
        <input type="text" id="num" value="1" />
        <a class="count-btn" id="add" data-mix="1">+</a>
        <span class="fl" style="line-height: 26px;font-size: 13px;">件（库存<{= stockNum }>件）</span>
       </form> 
      </div>
      <hr style="border-top:1px dashed #898989; border-bottom:none; height:1px; overflow:hidden;" /> 
      <div id="button" class="cf"> 
        <a id="paynow-btn" href="javascript:;" class="button orange">立即购买</a> 
        <a id="addcart-btn" href="javascript:;" class="button red">加入购物车</a> 
      </div> 
      <div id="paylink" class="cf"> 
       <strong>支付方式</strong> 
       <p><a target="_blank" href="#">货到付款（部分地区）</a><span>|</span><a target="_blank" href="#">礼品卡</a><span>|</span><a target="_blank" href="#">支付网上支付</a><span>|</span><a target="_blank" href="#">银行转账</a></p> 
      </div> 
      <div id="mid_border"> 
       <p>购物满150元可领取30元抵用券</p> 
       <a target="_blank" href="#"><img src="/O2OWebManager/iquick/assets/images/dizhi.png" alt="" /></a> 
      </div> 

  </script>

  <script type="text/template" id="t-detail-description" data-target="#description">
    <ul> 
  <p>规格参数</p> 
  <li><span>产地：马来西亚</span><span>口味：其他口味</span><span>产地：马来西亚</span></li> 
  <li><span>产地：马来西亚</span><span>口味：其他口味</span><span>产地：马来西亚</span></li> 
  <li><span>产地：马来西亚</span><span>口味：其他口味</span><span>产地：马来西亚</span></li> 
</ul> 
  </script>

  <script type="text/template" id="t-categories">
    

  </script>

  <script type="text/template" id="t-category-item">
    <{ $.each(sublevels, function(idx, subleave){ }>
  <div class="item btnone" data-cid="<{= subleave.category }>"> 
      <div class="product"> 
       <h3> <a href="#"><{= subleave.levelName }></a></h3> 
       <s style="display:block;"></s> 
      </div> 
      <div class="product-wrap posone"> 
       <!-- template --> 
      </div> 
     </div> 
<{ }); }>
  </script>

  <script type="text/javascript">

  	current = 9999;
    $(function(){

      IQ.meta = {
        id : '22',
        url : '/O2OWebManager/item/DetailAction?itemID=<%=request.getParameter("itemId")%>'
      };

      IQ.cart = {
        order: '/order',
        getcart: '/O2OWebManager/item/buyAction!getCart.action',
        collect: '/collect',
        remove: '/remove',
        add: '/O2OWebManager/item/buyAction!addItem.action'
      };

      seajs.config({
        debug: true,
        charset: 'utf-8'
      });

      seajs.use('module/detail');

    });

  </script>
  <!-- by daidai.in end -->


<div id="footer">
    <div id="border"> 
      <p><a target="_blank" href="#">关于我们</a><span> |</span><a target="_blank" href="#">我们的团队</a><span> |</span><a target="_blank" href="#">热门搜索</a><span> |</span><a target="_blank" href="#">爱快客评论</a><span> |</span><a target="_blank" href="#">诚聘英才</a><span> |</span><a target="_blank" href="#">商家登录</a><span> |</span><a target="_blank" href="#">快客新品</a></p> 
      <a>版权所有 &copy; 2014-2024 网上超市爱快客www.aquick.com保留全部权利. 网站运营：爱快客同城购物 网站备案：新ICP备13005397号-1</a> 
    </div> 

    <div class="desc">
      <img src="/O2OWebManager/iquick/assets/images/footer.png" /> 
    </div>
  </div>   
  </body>
</html>
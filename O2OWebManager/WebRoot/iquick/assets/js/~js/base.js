/*! aikuaike 0.1.1 2014-10-20 */
function cutString(a,b,c){if(a=htmlTextFormat(a),!a)return"";if(0>=b)return"";c||(c="");var d=characterLength(a);if(b>=d)return a;for(var e=characterLength(c),f=0,g=0;g<a.length;g++){if(a.charCodeAt(g)>255?f+=2:f++,f+e==b)return a.substring(0,g+1)+c;if(f+e>b)return a.substring(0,g)+c}return a}function htmlTextFormat(a){var b=replaceAll(a,"\r\n","");return b=replaceAll(b,"<br>",""),b=replaceAll(b,"<p>",""),b=replaceAll(b,"</p>",""),b=replaceAll(b,"&ldquo;","”"),b=replaceAll(b,"&rdquo;","“"),b=replaceAll(b,"&amp;","&")}function replaceAll(a,b,c){return a.replace(new RegExp(b,"gm"),c)}function characterLength(a){for(var b=0,c=0;c<a.length;c++)a.charCodeAt(c)>255?b+=2:b++;return b}function getEvent(){if(document.all)return window.event;for(func=getEvent.caller;null!=func;){var a=func.arguments[0];if(a&&(a.constructor==Event||a.constructor==MouseEvent||"object"==typeof a&&a.preventDefault&&a.stopPropagation))return a;func=func.caller}return null}function findDimensions(){var a=0,b=0,c=0,d=0;return window.innerWidth&&(a=window.innerHeight),document.body&&(document.body.clientWidth&&(b=document.body.clientHeight),document.body.scrollHeight&&(c=document.body.scrollHeight)),document.documentElement&&document.documentElement.clientWidth&&(d=document.documentElement.clientHeight),winHeight=Math.max(a,b,c,d)}function getCurrScrollTop(){var a=document.body.scrollTop;return 0==a&&(a=document.documentElement.scrollTop),a}function getCurrElementTop(a){return $("#"+a).offset().top-$(window).height()}function showShade(){if(!(jQuery("#layoutBg").length>0)){var a=$(document).height(),b=document.createElement("div");b.id="layoutBg",b.style.cssText="position:absolute;left:0px;top:0px;width:100%;height:"+a+"px;filter:Alpha(Opacity=50);-moz-opacity:0.5;-khtml-opacity:0.5;opacity:0.5; background-color:#000;z-index:1000;",document.body.appendChild(b)}}function closeShade(){$("#layoutBg").length>0&&$("#layoutBg").remove()}function resizeShade(){$("#layoutBg").length>0&&($("#layoutBg").css("height",$(document).height()),$("#layoutBg").css("width",$(document).width()))}function getQueryStringRegExp(a){var b=new RegExp("(^|\\?|&)"+a+"=([^&]*)(\\s|&|$)","i");if(b.test(location.href)){var c=unescape(RegExp.$2.replace(/\+/g," "));return""==c?"FALSE":c}return"FALSE"}function getAttrValueById(a,b){var c;c=1==arguments.length?"data-uri":b;var d=jQuery("#"+a).attr(c);return d?d:null}function tab(a){jQuery("#"+a+"t").find(".mt").mouseover(function(){var b=jQuery(this).attr("data-num"),c=jQuery(this).attr("data-first");jQuery(this).siblings().removeClass("cur").addClass("def"),jQuery(this).removeClass("def").addClass("cur"),0!=b&&(jQuery("#"+a+"c").find(".mc").hide(),jQuery("#"+a+"c_"+b).show(),"n"!=c&&(jQuery("#"+a+"c_"+b).find("img").each(function(){jQuery(this).attr("src",jQuery(this).attr("original"))}),jQuery(this).attr("data-first","n")))})}function getUserGroupId(){var a="";if(-1==usergroupid){usergroupid=100;var b=jQuery.cookie("userinfo");if(null!=b&&-1!=b.indexOf("|")){var c=b.split("|");usergroupid=c[3]}}return a=usergroupid}function getPrice(a,b,c){var d=getUserGroupId(),e=priceServer+"/price.do?id="+a+"&mid="+b+"&usergroupid="+d+"&callback=?";jQuery.getJSON(e,function(a){a!=undefined&&c(a)})}function login(a){var b,c=location.toString(),d=c.indexOf("?"),e=c.indexOf("mid"),f=c.indexOf("id"),g=c.indexOf("Cid"),h=c.indexOf("ruleid"),i="";b=-1!=d?c.substring(0,d):c,-1!=e&&(b+="?mid="+mid),-1!=f&&(i=-1==b.indexOf("?")?"?":"&",b+=i+"id="+getQueryStringRegExp("id")),-1!=g&&(i=-1==b.indexOf("?")?"?":"&",b+=i+"Cid="+getQueryStringRegExp("Cid")),-1!=h&&(i=-1==b.indexOf("?")?"?":"&",b+=i+"ruleid="+getQueryStringRegExp("ruleid"));var j=crossDomain+frontPath+"/Member/LoginForm.do?mid="+mid+"&returnUrl="+encodeURIComponent(b);a.href=j}function gotoMyAccount(a){var b=getAttrValueById(a),c=crossDomain+frontPath+"/Member/index.jsp?mid="+mid+"&url="+encodeURIComponent(b);jQuery("#"+a).attr({href:c,target:"_blank"})}function gotoBackProductUrl(){var a=jQuery("#gwqNum").val();return null==a||""==a?(alert("请输入你的购物券号！"),!1):/[^\d]/.test(a)?(alert("请输入正确的购物券号！"),jQuery("#gwqNum").val(""),!1):void window.open(crossDomain+frontPath+"/PackBuyProduct.do?id="+a+"&mid="+mid)}function cls(a){var b=jQuery("#"+a)[0],c=b.attributes["data-defvalue"].value;c==b.value&&(b.value="",b.style.color="#000")}function res(a){var b=jQuery("#"+a)[0];""==b.value&&(b.value=b.attributes["data-defvalue"].value,b.style.color="#999")}function checkTopSearchForm(){var a=jQuery("#topKeywords"),b=a.attr("data-URL");if(b&&a.val()==a.attr("data-defvalue"))return location.href=b,!1;var c=a.val();""!=c&&(c+=",title,mer_title,mer_title_,brand,cloumnName,keyword,keywords,articleRuleTitle,activeName,ProductFeatures"),jQuery("#thKeywords").val(jQuery.trim(c)),jQuery("#isKeyCommendClick").val("1")}function getTopLoginInfo(){var a=new Object;a.random_L=Math.random(),a.mid=mid;var b=crossDomain+frontPath+"/"+webIndex+"/finclude/includetoplogin.do?"+$.param(a)+"&callback=?";jQuery.getJSON(b,function(a){a&&jQuery("#top_login_span").html(a.wmLoginInfo)})}function initGouWuQuanInfo(){jQuery("#gwq").hover(function(){jQuery("#gwq_cont").show()},function(){gwq_t=setTimeout(function(){jQuery("#gwq_cont").hide()},"100")}),jQuery("#gwq_cont").hover(function(){clearTimeout(gwq_t),jQuery("#gwq_cont").show()},function(){jQuery("#gwq_cont").hide(),res("gwqNum"),jQuery("#gwqNum").blur()})}function initMyAccountInfo(){getTopLoginInfo(),jQuery("#myaccount").hover(function(){var a=jQuery(this).attr("data-first");if("yes"==a){var b=crossDomain+frontPath+"/"+webIndex+"/finclude/includetopmyaccount.do?t="+Math.random()+"&callback=?";$.getScript(b,function(){data&&data.html&&jQuery("#myaccount_cont").removeClass("loadding").html(data.html)}),jQuery(this).attr("data-first","no")}jQuery(this).addClass("myaccount_curr"),jQuery("#myaccount_cont").show()},function(){jQuery(this).removeClass("myaccount_curr"),jQuery("#myaccount_cont").hide()})}function addFavorite(a,b){try{window.external.addfavorite(b,a)}catch(c){try{window.sidebar.addPanel(a,b,"")}catch(c){alert("抱歉，您的浏览器不支持此操作！请您使用菜单栏或Ctrl+D收藏本站。")}}}function initAllSortsMenu(){if(!(jQuery("#categorys_mt").length<1)){var a=jQuery("#allmain_content").html();a!=undefined&&""!=a&&(jQuery("#categorys_mc").html(""),jQuery("#categorys_mc").append(a)),jQuery("#categorys_mt,#categorys_mc").hover(function(){jQuery("#allmain_content").show(),clearFstMenuTimer(),categorys_t=setTimeout(showFstMenu,300)},function(){jQuery("#allmain_content").hide(),clearFstMenuTimer(),categorys_t=setTimeout(hideFstMenu,300)}),jQuery("#categorys_mt").bind("click",showFstMenu),jQuery("h3[id^='main_menu_item'],.main_adv_item").hover(function(){var a=jQuery(this).attr("showpage");clearTimeout(showlist_t),showlist_t=setTimeout(function(){mainMenuMouseOver(a),jQuery(".main_content").show()},120)},function(){clearTimeout(showlist_t);var a=jQuery(this).attr("showpage");showlist_t=setTimeout(function(){mainMenuMouseOut(a),jQuery(".main_content").hide()},120)})}}function clearFstMenuTimer(){clearTimeout(categorys_t),categorys_t=-1}function showFstMenu(){jQuery("#categorys_mc").slideDown(400,clearFstMenuTimer),jQuery("#categorys_mt").unbind("click").bind("click",hideFstMenu),jQuery("#categorys_mt i").addClass("cur")}function hideFstMenu(){jQuery("#categorys_mc").slideUp(400,clearFstMenuTimer),jQuery("#categorys_mt").unbind("click").bind("click",showFstMenu),jQuery("#categorys_mt i").removeClass("cur")}function mainMenuMouseOver(a){jQuery("#main_menu_focus").addClass("main_menu_item"),jQuery("#main_menu_focus").attr("id","main_menu_item"+jQuery("#main_menu_focus").attr("showpage")),jQuery("#main_menu_item"+a).removeClass("main_menu_item"),jQuery("#main_menu_item"+a).attr("id","main_menu_focus"),jQuery("#main_adv_"+lastMenuShowId).hide(),jQuery("#main_adv_"+a).show(),lastMenuShowId=a}function mainMenuMouseOut(){jQuery(".main_adv_item").hide(),lastMenuShowId="default",jQuery("#main_adv_"+lastMenuShowId).show(),jQuery("#main_menu_focus").addClass("main_menu_item"),jQuery("#main_menu_focus").attr("id","main_menu_item"+jQuery("#main_menu_focus").attr("showpage"))}function callbackSetSmallCartAmount(a){a&&a.totalAmount>=0&&($("#smallcart_items_amount").attr("data-count",0),$("#smallcart_items_amount").val(a.cartitemsAmount+""),$("#smallcart").attr("data-first","yes"),$(".smallcart_totalamount").html(a.totalAmount+""),$("#totalMustPayPrice").html(a.totalMustPayPrice.toFixed(2)+""))}function getCartTotalAmount(){var a=crossDomain+frontPath+"/frontendjson/smallcartinfo.do?mid="+mid+"&callback=?&t="+Math.random();jQuery.getJSON(a,callbackSetSmallCartAmount)}function getCartTotalAmountForMax(){setTimeout(function(){var a=$("#smallcart_items_amount"),b=a.attr("data-count");"init"==a.val()&&3>b?(getCartTotalAmount(),getCartTotalAmountForMax(),b++,a.attr("data-count",b)):loadSmallCartContent()},"300")}function deleteSmallCart(a,b,c,d){try{deleteOneItem(b)}catch(e){}jQuery("#delsmallcart"+d+"_"+a+"_"+b).hide();var f=new Object;f.mid=mid,f.cartid=a;1==c?(f.productid=0,f.presentid=b,uri=crossDomain+frontPath+"/frontendjson/delpresent.do?"+$.param(f)+"&callback=?"):(f.productid=b,uri=crossDomain+frontPath+"/frontendjson/delcartitem.do?"+$.param(f)+"&callback=?"),jQuery.getJSON(uri,f,callbackSetSmallCartAmount)}function deleteSmallCartXY(a,b){jQuery("#delsmallcartxy_"+a+"_"+b).hide();var c={};c.mid=mid,c.cartid=a,c.ruleid=b,uri=crossDomain+frontPath+"/delcartitemxy.do?"+$.param(c)+"&callback=?",jQuery.getJSON(uri,getCartTotalAmount)}function isShowSmallcartScrollBar(a){0==a?(jQuery("#smallcart_cont").html("<div class='smallcart_amount0'>购物车中还没有商品，赶紧选购吧！</div>"),jQuery("#smallcart").attr("data-first","no")):a>=5&&jQuery("#smallcart_scroll").css("overflow-y","scroll")}function loadSmallCartContent(){var a=$("#smallcart_items_amount").val();if("init"==a)return $("#smallcart_cont").html("<div class='smallcart_amount0'>网络繁忙，请稍候重试~</div>"),void setTimeout(getCartTotalAmount,"500");isShowSmallcartScrollBar(a);var b=jQuery("#smallcart").attr("data-first");if("yes"==b){var c=crossDomain+frontPath+"/"+webIndex+"/finclude/includetopsmallcartcontent.do?mid="+mid+"&t="+Math.random();$.getScript(c,function(){data&&data.html&&($("#smallcart_cont").html(data.html),isShowSmallcartScrollBar(a),$(".xy_miniprice").length>0&&$(".xy_miniprice").each(function(){var a=parseFloat($(this).html());$(this).html(a)}))}),jQuery("#smallcart").attr("data-first","no")}}function gotoCart(a){jQuery("#"+a).html("请稍候..."),jQuery("#"+a+"_wait").show()}function initSmallCartInfo(){getCartTotalAmount(),$("#smallcart").hover(function(){getCartTotalAmountForMax(),jQuery("#cartlink").addClass("cartlink_curr"),jQuery("#carticon").addClass("carticon_curr"),jQuery("#cartarrow").addClass("cartarrow_curr"),jQuery("#smallcart_cont").show()},function(){jQuery("#cartlink").removeClass("cartlink_curr"),jQuery("#carticon").removeClass("carticon_curr"),jQuery("#cartarrow").removeClass("cartarrow_curr"),jQuery("#smallcart_cont").hide()})}function topFixed(){0!=jQuery("#rightbar").length&&(document.getElementById("rightbar").style.display=getCurrScrollTop()>300?"block":"none",navigator.userAgent.indexOf("MSIE 6.0")>0&&(document.getElementById("rightbar").style.top=document.documentElement.clientHeight+document.documentElement.scrollTop-document.getElementById("rightbar").clientHeight-44+"px",document.getElementById("rightbar").style.position="absolute"))}function initRightBar(){0!=jQuery("#rightbar").length&&(jQuery("#rightbar a.def").hover(function(){var a=jQuery(this).attr("data-tip");jQuery(this).addClass("curr").html(a)},function(){jQuery(this).removeClass("curr").html("")}),window.onscroll=topFixed,window.resize=topFixed,topFixed(),initHotDeal())}function initHotDeal(){hideAdv(),jQuery("#hot_deal_def").click(showAdv).hover(function(){t_hotDeal=setTimeout(function(){isShowHotDeal&&(showAdv(),isShowHotDeal=!1)},250)}),jQuery("#hot_deal_cur").click(function(){closeHotDeal(),isShowHotDeal=!1}),jQuery("#hot_deal_close").click(closeHotDeal)}function showAdv(){jQuery("#hot_deal_layer,#hot_deal_close,#hot_deal_dovt,#hot_deal_cur").fadeIn(400);var a=jQuery("#hot_deal_img"),b=a.attr("data-first");if("y"==b&&(a.find(".lazyload").attr("src",a.find(".lazyload").attr("original")),a.attr("data-first","n")),"y"==a.attr("data-firstrequest")){a.attr("data-firstrequest","n");var c=frontPath+"/"+webIndex+"/finclude/commonadv.do",d={};d.placeId=$.cookie("userinfo")?155260:155860,d.t="",$.post(c,d,function(a){$("#hot_deal_img").html(a)})}}function closeHotDeal(){jQuery("#hot_deal_def").fadeIn(400),jQuery("#hot_deal_layer,#hot_deal_close,#hot_deal_dovt,#hot_deal_cur").fadeOut(400,hideAdv)}function hideAdv(){jQuery("#hot_deal_layer,#hot_deal_cur").hide()}function initCpsParams(){var a=getQueryStringRegExp("xcid"),b=getQueryStringRegExp("wid"),c=getQueryStringRegExp("fbt"),d=getQueryStringRegExp("url"),e=getQueryStringRegExp("cgw_id"),f=getQueryStringRegExp("cgw_url"),g=getQueryStringRegExp("source"),h=getQueryStringRegExp("adsq_source"),i=getQueryStringRegExp("adsq_sid"),j=getQueryStringRegExp("adsq_url"),k=getQueryStringRegExp("utm_source"),l=getQueryStringRegExp("utm_medium"),m=getQueryStringRegExp("utm_term"),n=getQueryStringRegExp("utm_content"),o=getQueryStringRegExp("utm_campaign"),p=getQueryStringRegExp("lkt_a_id"),q=getQueryStringRegExp("lkt_m_id"),r=getQueryStringRegExp("lkt_url"),s=getQueryStringRegExp("wy_cid"),t=getQueryStringRegExp("wy_url"),u=getQueryStringRegExp("dm_sid"),v=getQueryStringRegExp("dm_feedback"),w=getQueryStringRegExp("dm_to"),x=getQueryStringRegExp("wb_Adid"),y=getQueryStringRegExp("wb_Source"),z=getQueryStringRegExp("position"),A=getQueryStringRegExp("targeturl"),B=getQueryStringRegExp("ls_from"),C=getQueryStringRegExp("abmm_from"),D="",E="";"FALSE"!=a?D=a+","+b+","+c+","+d+",yima":"FALSE"!=e?D=e+","+g+","+f+",cgw":"FALSE"!=h?(D=i+","+h+","+j+",adsqcps",E=j):"FALSE"!=p?(D=p+","+q+","+r+",lktcps",E=r):"FALSE"!=s?(D=s+","+t+",wycps",E=t):"FALSE"!=u?(D=u+","+v+","+w+",dmcps",E=w):"FALSE"!=k?D="utm_source="+k+"&utm_medium="+l+"&utm_term="+m+"&utm_content="+n+"&utm_campaign="+o:"FALSE"!=x?(D=x+","+y+","+z+","+A+",wb_Adid",E=A):"FALSE"!=B?D=B+",lscps":"FALSE"!=C&&(D=C+",abmmcps"),""!=D&&(document.cookie="cps="+escape(D)+";path=/"),""!=E&&"FALSE"!=E&&(window.location=E)}function initLazyloadParams(){0!=jQuery("img.lazyload").length&&jQuery("img.lazyload").lazyload({threshold:0,skip_invisible:!1,failure_limit:4})}function createPopup(){var a=document.createElement("div");a.id="tb_layer",a.style.cssText="position:fixed;z-index:10500;left:45%;top:30%;margin-left:-173px!important; margin-top:-86px!important; width:345px;/*IE6*/_position:absolute;_top: expression(eval(document.compatMode &&document.compatMode=='CSS1Compat') ?documentElement.scrollTop + (document.documentElement.clientHeight-this.offsetHeight)/2 + 150 :document.body.scrollTop + (document.body.clientHeight - this.clientHeight)/2);}",document.body.appendChild(a)}function showLoginShade(){var a=$(document).height(),b=document.createElement("div");b.id="layoutBg",b.style.cssText="position:absolute;left:0px;top:0px;width:100%;height:"+a+"px;filter:Alpha(Opacity=50);-moz-opacity:0.5;-khtml-opacity:0.5;opacity:0.5; background-color:#000;z-index:10000;",document.body.appendChild(b)}var undefined,usergroupid=-1,gwq_t=0,lastMenuShowId="default",categorys_t=-1,showlist_t=-1,isShowHotDeal=!0;jQuery(function(){initAllSortsMenu(),initLazyloadParams(),initGouWuQuanInfo(),initRightBar(),initCpsParams()});
/*! aikuaike 0.1.1 2014-10-20 */
var ddsmoothmenu={arrowimages:{down:["downarrowclass","down.gif",23],right:["rightarrowclass","right.gif"]},transition:{overtime:300,outtime:300},shadow:{enable:!0,offsetx:5,offsety:5},showhidedelay:{showdelay:100,hidedelay:200},detectwebkit:-1!=navigator.userAgent.toLowerCase().indexOf("applewebkit"),detectie6:document.all&&!window.XMLHttpRequest,getajaxmenu:function(a,b){var c=a("#"+b.contentsource[0]);c.html("Loading Menu..."),a.ajax({url:b.contentsource[1],async:!0,error:function(a){c.html("Error fetching content. Server Response: "+a.responseText)},success:function(d){c.html(d),ddsmoothmenu.buildmenu(a,b)}})},buildmenu:function(a,b){var c=ddsmoothmenu,d=a("#"+b.mainmenuid+">ul");d.parent().get(0).className=b.classname||"ddsmoothmenu";var e=d.find("ul").parent();e.hover(function(){a(this).children("a:eq(0)").addClass("selected")},function(){a(this).children("a:eq(0)").removeClass("selected")}),e.each(function(d){var e=a(this).css({zIndex:100-d}),f=a(this).find("ul:eq(0)").css({display:"block"});if(f.data("timers",{}),this._dimensions={w:this.offsetWidth,h:this.offsetHeight,subulw:f.outerWidth(),subulh:f.outerHeight()},this.istopheader=1==e.parents("ul").length?!0:!1,f.css({top:this.istopheader&&"v"!=b.orientation?this._dimensions.h+"px":0}),c.shadow.enable){if(this._shadowoffset={x:this.istopheader?f.offset().left+c.shadow.offsetx:this._dimensions.w,y:this.istopheader?f.offset().top+c.shadow.offsety:e.position().top},this.istopheader)$parentshadow=a(document.body);else{var g=e.parents("li:eq(0)");$parentshadow=g.get(0).$shadow}this.$shadow=a('<div class="ddshadow'+(this.istopheader?" toplevelshadow":"")+'"></div>').prependTo($parentshadow).css({left:this._shadowoffset.x+"px",top:this._shadowoffset.y+"px"})}e.hover(function(){var d=f,g=e.get(0);clearTimeout(d.data("timers").hidetimer),d.data("timers").showtimer=setTimeout(function(){g._offsets={left:e.offset().left,top:e.offset().top};var f=g.istopheader&&"v"!=b.orientation?0:g._dimensions.w;if(f=g._offsets.left+f+g._dimensions.subulw>a(window).width()?g.istopheader&&"v"!=b.orientation?-g._dimensions.subulw+g._dimensions.w:-g._dimensions.w:f,d.queue().length<=1&&(d.css({left:f+"px",width:g._dimensions.subulw+"px"}).animate({height:"show",opacity:"show"},ddsmoothmenu.transition.overtime),c.shadow.enable)){var h=g.istopheader?d.offset().left+ddsmoothmenu.shadow.offsetx:f,i=g.istopheader?d.offset().top+c.shadow.offsety:g._shadowoffset.y;!g.istopheader&&ddsmoothmenu.detectwebkit&&g.$shadow.css({opacity:1}),g.$shadow.css({overflow:"",width:g._dimensions.subulw+"px",left:h+"px",top:i+"px"}).animate({height:g._dimensions.subulh+"px"},ddsmoothmenu.transition.overtime)}},ddsmoothmenu.showhidedelay.showdelay)},function(){var a=f,b=e.get(0);clearTimeout(a.data("timers").showtimer),a.data("timers").hidetimer=setTimeout(function(){a.animate({height:"hide",opacity:"hide"},ddsmoothmenu.transition.outtime),c.shadow.enable&&(ddsmoothmenu.detectwebkit&&b.$shadow.children("div:eq(0)").css({opacity:0}),b.$shadow.css({overflow:"hidden"}).animate({height:0},ddsmoothmenu.transition.outtime))},ddsmoothmenu.showhidedelay.hidedelay)})}),d.find("ul").css({display:"none",visibility:"visible"})},init:function(a){if("object"==typeof a.customtheme&&2==a.customtheme.length){var b="#"+a.mainmenuid,c="v"==a.orientation?b:b+", "+b;document.write('<style type="text/css">\n'+c+" ul li a {background:"+a.customtheme[0]+";}\n"+b+" ul li a:hover {background:"+a.customtheme[1]+";}\n</style>")}this.shadow.enable=document.all&&!window.XMLHttpRequest?!1:this.shadow.enable,jQuery(document).ready(function(b){"object"==typeof a.contentsource?ddsmoothmenu.getajaxmenu(b,a):ddsmoothmenu.buildmenu(b,a)})}};
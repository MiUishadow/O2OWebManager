/*! aikuaike 0.1.0 2014-09-28 */
define("module/regist",["clib/network","clib/toastr/toastr","clib/validate.extend","clib/verify.code"],function(a){var b=a("clib/network"),c=a("clib/toastr/toastr");a("clib/validate.extend"),a("clib/verify.code"),$("#registform").validate({onSubmit:!0,onBlur:!0,eachValidField:function(){$(this).removeClass("invalid").addClass("success")},eachInvalidField:function(){$(this).removeClass("success").addClass("invalid")},valid:function(){var a=$(this),b=a.attr("action"),c=a.serializeArray();d.call(this,b,c)},invalid:function(){},description:{username:{required:'<div class="error">注册邮箱不能为空</div>',pattern:'<div class="error">注册邮箱仅含: 字母 数字 ._@</div>',conditional:"conditional"},password:{required:'<div class="error">密码必填</div>',pattern:"pattern",conditional:'<div class="error">密码长度至少6位</div>'},rpassword:{required:'<div class="error">确认密码必填</div>',conditional:'<div class="error">两次密码输入不一致</div>'},verifycode:{required:'<div class="error">请填写验证码</div>',conditional:'<div class="error">验证码不正确</div>'}}});var d=function(a,d){var e=$(this),f=$("button[type=submit]",e);"posting"!=e.data("posting")&&(e.data("posting","posting"),f.text("提交中..."),$("#for-request").html(""),b.post(a,function(a){a.RegResult?(c.success("注册成功，正在跳转..."),setTimeout(function(){window.location.href=a.url},1500)):(c.error(a.info),e.data("posting","posted"),f.text("注册"))},function(){e.data("posting","posted"),f.text("注册"),c.warning("注册失败，请稍后再试.")},{data:d}))}}),define("clib/network",[],function(a,b){var c={url:"",type:"GET",dataType:"json",timeout:6e4},d=function(a,b,d){return d="object"==typeof a?$.extend({},c,a):"object"==typeof b?$.extend({},c,b):$.extend({},c,d),d.success=function(b){"function"==typeof a&&a(b)},d.error=function(a){"function"==typeof b&&b(a)},d};b.get=function(a,b,c,e){e=d(b,c,e),e.url=a,$.ajax(e)},b.post=function(a,b,c,e){e=d(b,c,e),e.url=a,e.type="POST",$.ajax(e)},b.script=function(a,b,c,e){e=d(b,c,e),e.url=a,e.dataType="script",$.ajax(e)},b.text=function(a,b,c,e){e=d(b,c,e),e.url=a,e.dataType="text",$.ajax(e)}}),function(a){a("clib/toastr/toastr",[],function(){return function(){function a(a,b,c){return n({type:t.error,iconClass:o().iconClasses.error,message:a,optionsOverride:c,title:b})}function b(a,b){return a||(a=o()),q=$("#"+a.containerId),q.length?q:(b&&(q=k(a)),q)}function c(a,b,c){return n({type:t.info,iconClass:o().iconClasses.info,message:a,optionsOverride:c,title:b})}function d(a){r=a}function e(a,b,c){return n({type:t.success,iconClass:o().iconClasses.success,message:a,optionsOverride:c,title:b})}function f(a,b,c){return n({type:t.warning,iconClass:o().iconClasses.warning,message:a,optionsOverride:c,title:b})}function g(a){var c=o();q||b(c),j(a,c)||i(c)}function h(a){var c=o();return q||b(c),a&&0===$(":focus",a).length?void p(a):void(q.children().length&&q.remove())}function i(a){for(var b=q.children(),c=b.length-1;c>=0;c--)j($(b[c]),a)}function j(a,b){return a&&0===$(":focus",a).length?(a[b.hideMethod]({duration:b.hideDuration,easing:b.hideEasing,complete:function(){p(a)}}),!0):!1}function k(a){return q=$("<div/>").attr("id",a.containerId).addClass(a.positionClass).attr("aria-live","polite").attr("role","alert"),q.appendTo($(a.target)),q}function l(){return{tapToDismiss:!0,toastClass:"toast",containerId:"toast-container",debug:!1,showMethod:"fadeIn",showDuration:300,showEasing:"swing",onShown:void 0,hideMethod:"fadeOut",hideDuration:1e3,hideEasing:"swing",onHidden:void 0,extendedTimeOut:1e3,iconClasses:{error:"toast-error",info:"toast-info",success:"toast-success",warning:"toast-warning"},iconClass:"toast-info",positionClass:"toast-top-right",timeOut:5e3,titleClass:"toast-title",messageClass:"toast-message",target:"body",closeHtml:"<button>&times;</button>",newestOnTop:!0}}function m(a){r&&r(a)}function n(a){function c(a){return!$(":focus",i).length||a?i[f.hideMethod]({duration:f.hideDuration,easing:f.hideEasing,complete:function(){p(i),f.onHidden&&"hidden"!==n.state&&f.onHidden(),n.state="hidden",n.endTime=new Date,m(n)}}):void 0}function d(){(f.timeOut>0||f.extendedTimeOut>0)&&(h=setTimeout(c,f.extendedTimeOut))}function e(){clearTimeout(h),i.stop(!0,!0)[f.showMethod]({duration:f.showDuration,easing:f.showEasing})}var f=o(),g=a.iconClass||f.iconClass;"undefined"!=typeof a.optionsOverride&&(f=$.extend(f,a.optionsOverride),g=a.optionsOverride.iconClass||g),s++,q=b(f,!0);var h=null,i=$("<div/>"),j=$("<div/>"),k=$("<div/>"),l=$(f.closeHtml),n={toastId:s,state:"visible",startTime:new Date,options:f,map:a};return a.iconClass&&i.addClass(f.toastClass).addClass(g),a.title&&(j.append(a.title).addClass(f.titleClass),i.append(j)),a.message&&(k.append(a.message).addClass(f.messageClass),i.append(k)),f.closeButton&&(l.addClass("toast-close-button").attr("role","button"),i.prepend(l)),i.hide(),f.newestOnTop?q.prepend(i):q.append(i),i[f.showMethod]({duration:f.showDuration,easing:f.showEasing,complete:f.onShown}),f.timeOut>0&&(h=setTimeout(c,f.timeOut)),i.hover(e,d),!f.onclick&&f.tapToDismiss&&i.click(c),f.closeButton&&l&&l.click(function(a){a.stopPropagation?a.stopPropagation():void 0!==a.cancelBubble&&a.cancelBubble!==!0&&(a.cancelBubble=!0),c(!0)}),f.onclick&&i.click(function(){f.onclick(),c()}),m(n),f.debug&&console&&console.log(n),i}function o(){return $.extend({},l(),u.options)}function p(a){q||(q=b()),a.is(":visible")||(a.remove(),a=null,0===q.children().length&&q.remove())}var q,r,s=0,t={error:"error",info:"info",success:"success",warning:"warning"},u={clear:g,remove:h,error:a,getContainer:b,info:c,options:{},subscribe:d,success:e,version:"2.0.3",warning:f};return u.options={debug:!1,positionClass:"toast-top-right",showDuration:"300",hideDuration:"800",timeOut:"3000",extendedTimeOut:"800",showEasing:"swing",hideEasing:"linear",showMethod:"fadeIn",hideMethod:"fadeOut"},u}()})}("function"==typeof define&&define.cmd?define:function(a,b){"undefined"!=typeof module&&module.exports?module.exports=b(jQuery):window.toastr=b(jQuery)}),define("clib/validate.extend",["clib/validate"],function(a){a("clib/validate"),$.validateExtend({password:{required:!0,conditional:function(a){return String(a).length>=6}},rpassword:{required:!0,conditional:function(a){return $("input[name=pwd]").val()==a}},username:{required:!0,pattern:/^[_a-zA-Z0-9\@\.]+$/},verifycode:{required:!0,conditional:function(a){return 4==String(a).length}}})}),define("clib/validate",[],function(){!function(a,b,c,d){var e=['input:not([type]),input[type="color"],input[type="date"],input[type="datetime"],input[type="datetime-local"],input[type="email"],input[type="file"],input[type="hidden"],input[type="month"],input[type="number"],input[type="password"],input[type="range"],input[type="search"],input[type="tel"],input[type="text"],input[type="time"],input[type="url"],input[type="week"],textarea',"select",'input[type="checkbox"],input[type="radio"]'],f=e.join(","),g={},h=function(a,c){var f={pattern:!0,conditional:!0,required:!0},h=b(this),i=h.val()||"",j=h.data("validate"),k=j!==d?g[j]:{},l=h.data("prepare")||k.prepare,m=h.data("pattern")||("regexp"==b.type(k.pattern)?k.pattern:/(?:)/),n=h.attr("data-ignore-case")||h.data("ignoreCase")||k.ignoreCase,o=h.data("mask")||k.mask,p=h.data("conditional")||k.conditional,q=h.data("required"),r=h.data("describedby")||k.describedby,s=h.data("description")||k.description,t=h.data("trim"),u=/^(true|)$/i,v=/^false$/i,s=b.isPlainObject(s)?s:c.description[s]||{};if(q=""!=q?q||!!k.required:!0,t=""!=t?t||!!k.trim:!0,u.test(t)&&(i=b.trim(i)),b.isFunction(l)?i=String(l.call(h,i)):b.isFunction(c.prepare[l])&&(i=String(c.prepare[l].call(h,i))),"regexp"!=b.type(m)&&(n=!v.test(n),m=n?RegExp(m,"i"):RegExp(m)),p!=d)if(b.isFunction(p))f.conditional=!!p.call(h,i,c);else for(var w=p.split(/[\s\t]+/),x=0,y=w.length;y>x;x++)c.conditional.hasOwnProperty(w[x])&&!c.conditional[w[x]].call(h,i,c)&&(f.conditional=!1);if(q=u.test(q),q&&(h.is(e[0]+","+e[1])?!i.length>0&&(f.required=!1):h.is(e[2])&&(h.is("[name]")?0==b('[name="'+h.prop("name")+'"]:checked').length&&(f.required=!1):f.required=h.is(":checked"))),h.is(e[0]))if(m.test(i)){if("keyup"!=a.type&&o!==d){for(var z=i.match(m),A=0,y=z.length;y>A;A++)o=o.replace(RegExp("\\$\\{"+A+"(?::`([^`]*)`)?\\}","g"),z[A]!==d?z[A]:"$1");o=o.replace(/\$\{\d+(?::`([^`]*)`)?\}/g,"$1"),m.test(o)&&h.val(o)}}else q?f.pattern=!1:i.length>0&&(f.pattern=!1);var B=b('[id="'+r+'"]'),C=s.valid;return B.length>0&&"keyup"!=a.type&&(f.required?f.pattern?f.conditional||(C=s.conditional):C=s.pattern:C=s.required,B.html(C||"")),"function"==typeof k.each&&k.each.call(h,a,f,c),c.eachField.call(h,a,f,c),f.required&&f.pattern&&f.conditional?(c.waiAria&&h.prop("aria-invalid",!1),"function"==typeof k.valid&&k.valid.call(h,a,f,c),c.eachValidField.call(h,a,f,c)):(c.waiAria&&h.prop("aria-invalid",!0),"function"==typeof k.invalid&&k.invalid.call(h,a,f,c),c.eachInvalidField.call(h,a,f,c)),f};b.extend({validateExtend:function(a){return b.extend(g,a)},validateSetup:function(c){return b.extend(a,c)}}).fn.extend({validate:function(c){return c=b.extend({},a,c),b(this).validateDestroy().each(function(){var a=b(this);if(a.is("form")){a.data(name,{options:c});var d=a.find(f),g=c.namespace;a.is("[id]")&&(d=d.add('[form="'+a.prop("id")+'"]').filter(f)),d=d.filter(c.filter),c.onKeyup&&d.filter(e[0]).on("keyup."+g,function(a){h.call(this,a,c)}),c.onBlur&&d.on("blur."+g,function(a){h.call(this,a,c)}),c.onChange&&d.on("change."+g,function(a){h.call(this,a,c)}),c.onSubmit&&a.on("submit."+g,function(e){var f=!0;d.each(function(){var a=h.call(this,e,c);a.pattern&&a.conditional&&a.required||(f=!1)}),f?(c.sendForm||e.preventDefault(),b.isFunction(c.valid)&&c.valid.call(a,e,c)):(e.preventDefault(),e.stopImmediatePropagation(),b.isFunction(c.invalid)&&c.invalid.call(a,e,c))})}})},validateDestroy:function(){var a=b(this),c=a.data(name);if(a.is("form")&&b.isPlainObject(c)&&"string"==typeof c.options.nameSpace){var d=a.removeData(name).find(f).add(a);a.is("[id]")&&(d=d.add(b('[form="'+a.prop("id")+'"]').filter(f))),d.off("."+c.options.nameSpace)}return a}})}({sendForm:!1,waiAria:!0,onSubmit:!0,onKeyup:!1,onBlur:!1,onChange:!1,nameSpace:"validate",conditional:{},prepare:{},description:{},eachField:$.noop,eachInvalidField:$.noop,eachValidField:$.noop,invalid:$.noop,valid:$.noop,filter:"*"},jQuery,window)}),define("clib/verify.code",[],function(){$(".verify-code-change").on("click",function(){var a=$(this),b=$(a.data("ref")),c=b.data("src"),d=(new Date).getTime()+"";b.attr("src",c+d)}),$(".verify-code-input").one("focus",function(){var a=$(this),b=$(a.data("ref")),c=b.data("src"),d=(new Date).getTime()+"";b.attr("src",c+d)}).val("")});
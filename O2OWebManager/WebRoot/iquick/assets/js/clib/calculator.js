/*! aikuaike 0.1.0 2014-09-28 */
define("clib/calculator",[],function(a,b){var c=function(a,b){for(var c=0,d=a.length,e=0,f=[];d>c;c++)e=parseFloat(a[c]),f[c]=isNaN(e)?1:e;return a=null,b(f)},d=function(a){var b=0;for(var c in a)b+=a[c];return b.toFixed(1)},e=function(a){var b=1;for(var c in a)b*=a[c];return b.toFixed(1)},f=function(){var a=1;for(var b in args)a/=args[b];return a.toFixed(1)};b.mult=function(){return c(arguments,e)},b.sum=function(){return c(arguments,d)},b.except=function(){return c(arguments,f)}});
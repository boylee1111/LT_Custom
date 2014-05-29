if(!lt.util.load.provided_QMARK_('lt.plugins.trail-whitespace')) {
goog.provide('lt.plugins.trail_whitespace');
goog.require('cljs.core');
goog.require('lt.objs.command');
goog.require('lt.objs.command');
goog.require('lt.objs.editor');
goog.require('lt.objs.editor');
goog.require('lt.object');
goog.require('lt.object');

lt.plugins.trail_whitespace.overlay = cljs.core.clj__GT_js.call(null,new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"token","token",1124445547),(function (stream){var temp__4092__auto__ = stream.next();if(cljs.core.truth_(temp__4092__auto__))
{var _ = temp__4092__auto__;var s = stream.string;var length = s.length;var space_count = cljs.core.count.call(null,cljs.core.take_while.call(null,((function (s,length){
return (function (p1__7223_SHARP_){return p1__7223_SHARP_.match(/\s/);
});})(s,length))
,cljs.core.reverse.call(null,s)));var space_start = (length - space_count);if((space_start > stream.pos))
{stream.pos = space_start;
return null;
} else
{stream.pos = length;
return "trailingspace";
}
} else
{return null;
}
})], null));

lt.plugins.trail_whitespace.__BEH__show_trailing_whitespace = (function __BEH__show_trailing_whitespace(this$){return lt.objs.editor.__GT_cm_ed.call(null,this$).addOverlay(lt.plugins.trail_whitespace.overlay);
});
lt.object.behavior_STAR_.call(null,new cljs.core.Keyword("lt.plugins.trail-whitespace","show-trailing-whitespace","lt.plugins.trail-whitespace/show-trailing-whitespace",1043714670),new cljs.core.Keyword(null,"reaction","reaction",4441361819),lt.plugins.trail_whitespace.__BEH__show_trailing_whitespace,new cljs.core.Keyword(null,"triggers","triggers",2516997421),new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"object.instant","object.instant",773332388),null], null), null));

lt.plugins.trail_whitespace.__BEH__hide_trailing_whitespace = (function __BEH__hide_trailing_whitespace(this$){return lt.objs.editor.__GT_cm_ed.call(null,this$).removeOverlay(lt.plugins.trail_whitespace.overlay);
});
lt.object.behavior_STAR_.call(null,new cljs.core.Keyword("lt.plugins.trail-whitespace","hide-trailing-whitespace","lt.plugins.trail-whitespace/hide-trailing-whitespace",1234502819),new cljs.core.Keyword(null,"reaction","reaction",4441361819),lt.plugins.trail_whitespace.__BEH__hide_trailing_whitespace,new cljs.core.Keyword(null,"triggers","triggers",2516997421),new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 1, [new cljs.core.Keyword(null,"object.instant","object.instant",773332388),null], null), null));

lt.objs.command.command.call(null,new cljs.core.PersistentArrayMap(null, 3, [new cljs.core.Keyword(null,"command","command",1964298941),new cljs.core.Keyword(null,"toggle-trail-whitespace","toggle-trail-whitespace",4564664687),new cljs.core.Keyword(null,"desc","desc",1016984067),"Editor: Toggle trail whitespace",new cljs.core.Keyword(null,"exec","exec",1017031683),(function (){if(cljs.core.truth_(lt.object.in_tag_QMARK_.call(null,new cljs.core.Keyword(null,"editor","editor",4001043679),new cljs.core.Keyword("lt.plugins.trail-whitespace","show-trailing-whitespace","lt.plugins.trail-whitespace/show-trailing-whitespace",1043714670))))
{lt.object.remove_tag_behaviors.call(null,new cljs.core.Keyword(null,"editor","editor",4001043679),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword("lt.plugins.trail-whitespace","show-trailing-whitespace","lt.plugins.trail-whitespace/show-trailing-whitespace",1043714670)], null));
return lt.object.tag_behaviors.call(null,new cljs.core.Keyword(null,"editor","editor",4001043679),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword("lt.plugins.trail-whitespace","hide-trailing-whitespace","lt.plugins.trail-whitespace/hide-trailing-whitespace",1234502819)], null));
} else
{lt.object.remove_tag_behaviors.call(null,new cljs.core.Keyword(null,"editor","editor",4001043679),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword("lt.plugins.trail-whitespace","hide-trailing-whitespace","lt.plugins.trail-whitespace/hide-trailing-whitespace",1234502819)], null));
return lt.object.tag_behaviors.call(null,new cljs.core.Keyword(null,"editor","editor",4001043679),new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Keyword("lt.plugins.trail-whitespace","show-trailing-whitespace","lt.plugins.trail-whitespace/show-trailing-whitespace",1043714670)], null));
}
})], null));

}

//# sourceMappingURL=
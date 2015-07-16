(function($){
    $.extend($.fn, {
        tabtrigger: function(options) {
            var settings = $.extend({}, {
                url : this.attr('href') || this.data('url'),
                tabpaneid : this.data('tabpaneid'),
                tablabel : this.data('tablabel'),
                navtabs : this.data('navtabs'),
                tabcontent : this.data('tabcontent'),
                data : {}
            }, options);
            
            if (settings.url) {
                $.get(settings.url, settings.data, function(html) {
                    var $navtabs = $(settings.navtabs);
                    var $a = $navtabs.find('a[href*="' + settings.tabpaneid + '"]');
                    if ($a.size() > 0) {
                        $a.tab('show');   
                    } else {
                        var $span = $('<span class="glyphicon glyphicon-remove close">');
                        $a = $('<a/>').attr('href', '#' + settings.tabpaneid).text(settings.tablabel).append($span);
                        $navtabs.find('li.active').removeClass('active');
                        var $li = $('<li class="active"/>').append($a).appendTo($navtabs);
                        
                        var $tabcontent = $(settings.tabcontent);
                        $tabcontent.find('.tab-pane.active').removeClass('active');
                        var $div = $('<div class="tab-pane active"/>').attr('id', settings.tabpaneid).html(html).appendTo($tabcontent);
                        
                        $span.on('click', function(e) {
                            $navtabs.find('li:first a').tab('show');
                            $li.detach();
                            $div.detach();
                        });
                    }
                });
            }
        }
    });
})(jQuery);
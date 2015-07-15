$(function(){
    var $querybtn = $('#querybtn');
    var $pagecode = $('#pagecode');
    var $pageskip = $('#pageskip');
    var $maxpagecode = $('#maxpagecode');
    $('.pagination li:not(".active, .disabled") a').on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var pagecode = parseInt($this.data('pagecode'));
        $pagecode.val(pagecode);
        $querybtn.click();
    });
    $pageskip.on('keypress', function(e) {
        if (e.keyCode == 13) {
            e.preventDefault();
            var pagecode = parseInt($(this).val());
            if (!isNaN(pagecode)) {
                if (pagecode < 1) {
                    pagecode = 1;
                }
                var maxpagecode = $maxpagecode.val();
                if (pagecode > maxpagecode) {
                    pagecode = maxpagecode;
                }
                if (pagecode == $pagecode.val()) {
                    $pageskip.val(pagecode);
                } else {
                    $pagecode.val(pagecode);
                    $querybtn.click();
                }
            } else {
                $pageskip.val($pagecode.val());
            }
        }
    });
});
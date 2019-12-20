try {
    var menu = $('.js-item-menu');
    var sub_menu_is_showed = -1;

    for (var i = 0; i < menu.length; i++) {
        $(menu[i]).on('click', function (e) {
            e.preventDefault();
            $('.js-right-sidebar').removeClass("show-sidebar");
            if (jQuery.inArray(this, menu) == sub_menu_is_showed) {
                $(this).toggleClass('show-dropdown');
                sub_menu_is_showed = -1;
            }
            else {
                for (var i = 0; i < menu.length; i++) {
                    $(menu[i]).removeClass("show-dropdown");
                }
                $(this).toggleClass('show-dropdown');
                sub_menu_is_showed = jQuery.inArray(this, menu);
            }
        });
    }
    $(".js-item-menu, .js-dropdown").click(function (event) {
        event.stopPropagation();
    });

    $("body,html").on("click", function () {
        for (var i = 0; i < menu.length; i++) {
            menu[i].classList.remove("show-dropdown");
        }
        sub_menu_is_showed = -1;
    });

} catch (error) {
    console.log(error);
}

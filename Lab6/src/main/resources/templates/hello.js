$(document).ready(function() {
    $("#postBuddies").click(function() {
        $.ajax({
            url: "/buddyInfo",
            type: "POST"
        }).then(function(data) {
           $('.buddyInfo-name').append(data.name);
           $('.buddyInfo-address').append(data.address);
            $('.buddyInfo-tele').append(data.tele);
        });
    });

    $("#getBuddies").click(function() {
            $.ajax({
                url: "/buddyInfo",
                type: "GET"
            }).then(function(data) {
        });
    });
});

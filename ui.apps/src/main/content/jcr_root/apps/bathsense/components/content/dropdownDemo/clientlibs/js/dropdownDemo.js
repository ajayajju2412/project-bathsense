
$(document).ready(function(){
    $("button").click(function(){
        $.ajax({
            url: 'http://localhost:4502/content/wknd/us/en/_jcr_content.events.txt',
            type: 'GET',
            dataType: 'json',
            async: true,
            cache: false,
            success: function(responseJson){
               $.each(responseJson,function(index, event) {
                   var eventDiv = $("<div></div>").addClass("item1").text(event.text);
                   var descDiv = $("<div></div>").addClass("item2").text(event.description);
                   var imageDiv = $("<div></div>").addClass("item3").text(event.image);
                   $("#demo").append(eventDiv,descDiv,imageDiv);
               });
            }
        });
    });
});


$(document).ready(function(){
  $("p").click(function(){
    $(this).hide();
  });
});

$(document).ready(function(){
	  $("input").click(function(){
	    $("#submit1").hide();
	  });
	});

//$(document).ready(function(){
//$("#p1").hover(function(){
//	  alert("You entered p1!");
//	  },
//	  function(){
//	  alert("Bye! You now leave p1!");
//	}); 
//});

$(document).ready(function(){
	  $("input").focus(function(){
	    $(this).css("background-color","#D8D8D8");
	  });
	  $("input").blur(function(){
	    $(this).css("background-color","#ffffff");
	  });
	});

$(document).ready(function(){
	  $(".ex .hide").click(function(){
	    $(this).parents(".ex").hide("slow");
	  });
	});


$(document).ready(function(){
	  $("#hide").click(function(){
	    $("#hideshow").hide(1000);
	  });
	  $("#show").click(function(){
	    $("#hideshow").show(1000);
	  });
	});

$(document).ready(function(){
	  $("button").click(function(){
	    $("#togg1").toggle();
	    $("#togg2").toggle();
	  });
	});


$(function() {    $( "#menu" ).menu();  });

$("button").click(function(){
	  $("#div1").fadeIn();
	  $("#div2").fadeIn("slow");
	  $("#div3").fadeIn(3000);
	});


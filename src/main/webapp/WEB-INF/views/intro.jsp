<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<html>
<head>
<style type="text/css">
	body{
		background-image: url('resources/images/introphoto.png');
		background-size: cover;
	}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="resources/count/assets/ico/favicon.png">

    <title>Counter - Coming Soon Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/count/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/count/css/soon.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/respond.min.js"></script>
    <![endif]-->
    
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
	<script src="resources/count/js/jquery.min.js"></script>
	<script type="text/javascript" src="resources/count/js/modernizr.custom.js"></script>
    <script src="resources/count/js/bootstrap.min.js"></script>
    <script src="resources/count/js/soon/plugins.js"></script>
    <script src="resources/count/js/soon/jquery.themepunch.revolution.min.js"></script>
    <script src="resources/count/js/soon/custom.js"></script>
	<script type="text/javascript">

	$(document).ready(
	function() {
		var windex = 0;
		var mindex = 0;
		var coupleindex=0;
		
		var windexmax = ${wlistsize};
		var mindexmax = ${mlistsize};
		var coupleindexmax=${lastMatchedListsize};

		function userchange(target, index, count) {
			for (var i = 0; i < count; i++) {
				target.find('>span:eq(' + i + ')').attr("style",
						"display:none");
			}
			target.find('>span:eq(' + index + ')').attr("style",
					"display:block");
		}
		function couplechange(target, index, count) {
			for (var i = 0; i < count; i++) {
				target.find('>li:eq(' + i + ')').attr("style",
						"display:none");
			}
			target.find('>li:eq(' + index + ')').attr("style",
					"display:block");
		}
		function wspinner() {
			userchange($('#wlist'), windex, windexmax);
			windex++;
			if(windex==windexmax){
				windex=0;
			}
		}
		function mspinner() {
			userchange($('#mlist'), mindex, mindexmax);
			mindex++;
			if(mindex==mindexmax){
				mindex=0;
			}
		}
		function couplespinner() {
			couplechange($('#couple'), coupleindex, coupleindexmax);
			coupleindex++;
			if(coupleindex==coupleindexmax){
				coupleindex=0;
			}
		}
		
		wspinner();
		mspinner();
		couplespinner();
		
		setInterval(wspinner, 5000);
		setInterval(mspinner, 5000);
		setInterval(couplespinner, 5000);
/******************************************************************************************************************************
COMMING SOON PAGE
*******************************************************************************************************************************/
    /**
    * Set your date here  (YEAR, MONTH (0 for January/11 for December), DAY, HOUR, MINUTE, SECOND)
    * according to the GMT+0 Timezone
    **/
    /**
    * The script
    **/
    var todayMeetCount = '${todayMeetCount}';
    var totalMeetCount= '${TotalMeetCount}';
    var memberCount = '${ memberCount }';
    
    var firstindicator = $('#firstindicator');
    var secondindicator = $('#secondindicator');
    var thirdindicator = $('#thirdindicator');
    
    setDate();
    
    function setDate(){
        /* var now = new Date();
        if( launch < now ){
            firstindicator.html('<p>만난 사람 수</p><h1>0</H1><p>Day</p>');
            secondindicator.html('<h1>0</h1><p>Hour</p>');
            thirdindicator.html('<h1>0</h1><p>Minute</p>');
            fourthindicator.html('<h1>0</h1><p>Second</p>');
            message.html('OUR SITE IS NOT READY YET...');
        }
        else{} */
             	 var s = memberCount;
			     var d = '총 회원수';
			     firstindicator.html('<h1>'+s+'</h1><p>'+d+'</p>');
			     
			 
			     var s = todayMeetCount;
			     var d = '투데이 매칭'/* 단위 */;
			     secondindicator.html('<h1>'+s+'</h1><p>'+d+'</p>');
			 
			 	var s = totalMeetCount/* 넣어야 하는 수 */ ;
			     var d = '총 매칭'/* 단위 */;
			     thirdindicator.html('<h1>'+s+'</h1><p>'+d+'</p>');
        
    }
	});
/******************************************************************************************************************************
ANIMATIONS
*******************************************************************************************************************************/
(function($) {
    "use strict";
    var isMobile = false;
    if (navigator.userAgent.match(/Android/i) || 
        navigator.userAgent.match(/webOS/i) ||
        navigator.userAgent.match(/iPhone/i) || 
        navigator.userAgent.match(/iPad/i)|| 
        navigator.userAgent.match(/iPod/i) || 
        navigator.userAgent.match(/BlackBerry/i)) {                 
        isMobile = true;            
    }
    if (isMobile == true) {
        $('body').removeClass('nomobile');
        $('.animated').removeClass('animated');
    }
    $(function() {
        if (isMobile == false) {
            $('*[data-animated]').addClass('animated');
        }
        function animated_contents() {
            $(".animated:appeared").each(function (i) {
                var $this    = $(this),
                    animated = $(this).data('animated');

                setTimeout(function () {
                    $this.addClass(animated);
                }, 50 * i);
            });
        }
        animated_contents();
        $(window).scroll(function () {
            animated_contents();
        });
    });
})(jQuery);
/******************************************************************************************************************************
SLIDER
*******************************************************************************************************************************/
/******************************************************************************************************************************
BOOTSTRAP
*******************************************************************************************************************************/
/******************************************************************************************************************************
PROGRESS BAR
*******************************************************************************************************************************/
</script>

</head>
<body class="nomobile">
<div class="container-fluid">
<!-- START HEADER -->
        <div class="row">
            <header>
            </header>
            <div class="col-md-4">
            </div>
            <!-- START TIMER -->
            <div class="col-md-8" id="timer" data-animated="FadeIn">
                <p id="message"></p>
                <div id="firstindicator" class="timer_box"></div>
                <div id="secondindicator" class="timer_box"></div>
                <div id="thirdindicator" class="timer_box"></div>
            </div>
        </div>
        <!-- LAYER OVER THE SLIDER TO MAKE THE WHITE TEXTE READABLE -->
        <!-- END SLIDER -->
	
		<div class="row">
		<div class="col-md-4">
		</div>
			<div class="col-md-8">
				<h1>최근 등록된 만남</h1>
				
				<div id="wlist" class="col-md-4 text-center">
					<c:forEach items="${ wlist }" var="list">
						<span> <img
							class="img-responsive" style="border-radius:50%; width:150px; height:150px;" 
							src="/displayFile?fileName=${list.writer_photo}"
							alt="Attachment">
						</span>
					</c:forEach>
				</div>
				<div id="mlist">
					<c:forEach items="${ mlist }" var="list">
						<span> <img
							class="img-responsive" style="border-radius:50%; width:150px; height:150px;"
							src="/displayFile?fileName=${list.writer_photo}"
							alt="Attachment">
						</span>
					</c:forEach>
				</div>
			</div>
			</div>
			<div class="row">
			<div class="col-md-4">
			</div>
			<div class="col-md-8">
				<h1>최근 성사된 만남</h1>
				<ul id="couple">
					<c:forEach items="${ lastMatchedList }" var="list">
						<li><span> <img
								src="/displayFile?fileName=${list.writer_photo}"
								alt="Attachment"> <img
								src="/displayFile?fileName=/common/heart.png"
								alt="Attachment"> <img
								src="/displayFile?fileName=${list.partner_photo}"
								alt="Attachment">
						</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		</div>
</body>
</html>
<%@include file="include/footer.jsp"%>
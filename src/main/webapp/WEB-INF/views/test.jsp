<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- CSS includes -->
	<link href="resources/intromatch/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Karla" rel="stylesheet" type="text/css">
	<link href="/intromatchfonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/intromatch/css/theme.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>


<!-- Carousel -->
<div id="theme-carousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#theme-carousel" data-slide-to="0" class="active"></li>
		<li data-target="#theme-carousel" data-slide-to="1"></li>
		<li data-target="#theme-carousel" data-slide-to="2"></li>
	</ol>
	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="reasources/images/1.jpg" alt="carousel1" style="width:100%" />
			<div class="carousel-caption">
				<h1 class="text-danger">Design</h1>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry</p>
			</div>
		</div>
		<div class="item">
			<img src="/reasources/images/1.jpg" alt="carousel2" style="width:100%" />
			<div class="carousel-caption">
				<h1 class="text-danger">Development</h1>
				<p>Contrary to popular belief, Lorem Ipsum is not simply random text.</p>
			</div>
		</div>
		<div class="item">
			<img src="reasources/images/1.jpg" alt="carousel3" style="width:100%">
			<div class="carousel-caption">
				<h1 class="text-danger">Illustration</h1>
				<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
			</div>
		</div>
	</div>
	<!-- Controls -->
	<a class="left carousel-control" href="#theme-carousel" role="button" data-slide="prev">
        <div class="carousel-control-arrow">&#8249;</div>
	</a>
	<a class="right carousel-control" href="#theme-carousel" role="button" data-slide="next">
        <div class="carousel-control-arrow">&#8250;</div>
	</a>
</div>

<div class="container-about">
    <div class="container">
        <div class="page-header" id="about">
            <h1 class="text-center text-danger">Meet Our Team</h1>
			<h2 class="text-center">We are a small group of designers and developers</h2>
			<br />
        </div>
        <div class="row">
            <div class="col-md-4 text-center">
				<img class="img-responsive" style="border-radius:50%; width:250px; height:250px;" src="resources/images/1.jpg" />
				<h3 class="text-danger">Mike Miller</h3>
				<br />
                <p class="text-justify">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
			</div>
			<div class="col-md-4 text-center">
				<img class="img-responsive" style="border-radius:50%; width:250px; height:250px;" src="resources/images/1.jpg" />
				<h3 class="text-danger">Angelina Smithson</h3>
				<br />
				<p class="text-justify">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
			</div>
			<div class="col-md-4 text-center">
				<img class="img-responsive" style="border-radius:50%; width:250px; height:250px;" src="resources/images/1.jpg" />
			</div>
		</div>
    </div>
</div>

<!-- <div class="container-services">
    <div class="container">
	    <div class="page-header" id="services">
		    <h1 class="text-center text-danger">What We Do</h1>
		    <h2 class="text-center">We create clean, minimal websites and apps<br /></h2>
	    </div>
		<div class="row">
			<div class="col-md-2 text-center">
				<span class="services-circle text-center"><i class="fa fa-pencil fa-2x" aria-hidden="true"></i></span>
			</div>
			<div class="col-md-4 text-justify">
				<h3 class="text-danger">Design</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text</p>
			</div>
			<div class="col-md-2 text-center">
				<span class="services-circle text-center"><i class="fa fa-cogs fa-2x" aria-hidden="true"></i></span>
			</div>
			<div class="col-md-4 text-justify">
				<h3 class="text-danger">Development</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text</p>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-2 text-center">
				<span class="services-circle text-center"><i class="fa fa-users fa-2x" aria-hidden="true"></i></span>
			</div>
			<div class="col-md-4 text-justify">
				<h3 class="text-danger">Promotion</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text</p>
			</div>
			<div class="col-md-2 text-center">
				<span class="services-circle text-center"><i class="fa fa-camera fa-2x" aria-hidden="true"></i></span>
			</div>
			<div class="col-md-4 text-justify">
				<h3 class="text-danger">Illustration</h3>
				<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text</p>
			</div>
		</div>
    </div>
</div>

<div class="container-gallery">
    <div class="container">
        <div class="page-header" id="gallery">
            <h1 class="text-center text-danger">Our Works</h1>
			<h2 class="text-center">We create good brands<br /></h2>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <ul class="list-unstyled text-center">
                    <li class="filter btn btn-danger" data-filter="all">ALL</li>
                    <li class="filter btn btn-danger" data-filter=".graphic">GRAPHICS</li>
                    <li class="filter btn btn-danger" data-filter=".print">PRINT</li>
                    <li class="filter btn btn-danger" data-filter=".webdesign">WEB DESIGN</li>
                </ul>
            </div>
            <div class="mix graphic col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery1.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery1.jpg" />
                </a>
            </div>
            <div class="mix print col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery2.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery2.jpg" />
                </a>
            </div>
            <div class="mix webdesign col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery3.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery3.jpg" />
                </a>
            </div>
            <div class="mix webdesign col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery4.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery4.jpg" />
                </a>
            </div>
            <div class="mix print col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery5.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery5.jpg" />
                </a>
            </div>
            <div class="mix graphic col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery6.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery6.jpg" />
                </a>
            </div>
            <div class="mix webdesign col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery7.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery7.jpg" />
                </a>
            </div>
            <div class="mix webdesign col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery8.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery8.jpg" />
                </a>
            </div>
            <div class="mix graphic col-md-4 col-sm-6 col-xs-12">
                <a href="images/gallery/gallery9.jpg" class="img-wrapper">
                    <img class="img-responsive" src="images/gallery/gallery9.jpg" />
                </a>
            </div>
        </div>
    </div>
</div>

<div class="container-contact">
    <div class="container">
	    <div class="page-header" id="contact">
            <h1 class="text-center text-danger">Get In Touch With Us</h1>
			<br />
			<div class="row">
				<div class="col-md-6">
					<div id="googlemap"></div>
				</div>
				<div class="col-md-6">
					<form>
						<div class="form-group">
							<label for="form-name">Name</label>
							<input type="email" class="form-control" id="form-name" placeholder="Name">
						</div>
						<div class="form-group">
							<label for="form-email">Email Address</label>
							<input type="email" class="form-control" id="form-email" placeholder="Email Address">
						</div>
						<div class="form-group">
							<label for="form-subject">Telephone</label>
							<input type="text" class="form-control" id="form-subject" placeholder="Subject">
						</div>
						<div class="form-group">
							<label for="form-message">Email your Message</label>
							<textarea class="form-control" id="form-message" placeholder="Message"></textarea>
						</div>
						<button type="submit" class="btn btn-danger btn-lg">Register Now</button>
						<br /><br />
					</form>
				 </div>
			</div>
        </div>
    </div>
</div>

<footer id="subfooter" class="clearfix">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p style="font-size:18px;"><span class="fa fa-envelope-o text-color:#fff"></span> NEWSLETTER</p>
                <p>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Enter your email..." />
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="button">Subscribe</button>
                        </span>
                    </div>
                </p>
            </div>
        </div>
    </div>
</footer>

<footer id="footer" class="clearfix">
    <div class="container">
        <div class="row">
			<div class="col-md-4">
                <p>54, North Road, PA 45086, USA</p>
                <p>+1 888 455 6677</p>
                <p><a href="mailto:mail@example.com">mail@example.com</a></p>
			</div>
			<div class="col-md-4">
                <p>
                    <a class="fa fa-twitter footer-socialicon" target="_blank" href="https://twitter.com/"></a>
                    <a class="fa fa-facebook footer-socialicon" target="_blank" href="https://www.facebook.com/"></a>
                    <a class="fa fa-google-plus footer-socialicon" target="_blank" href="https://plus.google.com/"></a>
                    <a class="fa fa-linkedin footer-socialicon" target="_blank" href="https://plus.google.com/"></a>
                </p>
            </div>
            <div class="col-md-4">
                <p>Created by <a href="https://www.shieldui.com" title="Shield UI">Shield UI</a> and hosted <br /> by <a href="https://www.prepbootstrap.com" title="PrepBootstrap">PrepBootstrap</a></p>
            </div>
        </div>
    </div>
</footer> -->

<script src="js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/jquery.mixitup.min.js"></script>
<link href="css/magnific-popup.css" rel="stylesheet">
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script src="js/theme.js"></script>

<script type="text/javascript">
    jQuery(function($) {
		// Mix It Up Gallery and Magnific Popup setup
        $('.container-gallery').mixItUp();
        $('.container-gallery').magnificPopup({
            delegate: 'a',
            type: 'image'
        });
        // Google Maps setup
        var googlemap = new google.maps.Map(
            document.getElementById('googlemap'),
            {
                center: new google.maps.LatLng(44.5403, -78.5463),
                zoom: 8,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }
        );
    });
</script>

</body>
</html>

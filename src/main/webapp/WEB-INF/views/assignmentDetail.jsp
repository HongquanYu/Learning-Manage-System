<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!--icon link-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/resources/css/style_course.css">
</head>
<body>
	<!--navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"><img src="/resources/background/logo.png"></a>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="http://example.com"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Course </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Course1</a> <a
							class="dropdown-item" href="#">Course2</a> <a
							class="dropdown-item" href="#">Course3</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#">Messages</a>
				</li>
				<li class="nav-item"><a class="nav-link " href="#">Grades</a></li>
				<li class="nav-item"><a class="nav-link " href="#">Profile</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
		</div>
	</nav>


	<div class="container">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active"
				id="syllabus-tab" data-toggle="tab" href="#syllabus" role="tab"
				aria-controls="Syllabus" aria-selected="true">Syllabus</a></li>
			<li class="nav-item"><a class="nav-link" id="assignment-tab"
				data-toggle="tab" href="#assignment" role="tab"
				aria-controls="assignment" aria-selected="false">Assignment</a></li>
			<li class="nav-item"><a class="nav-link" id="grades-tab"
				data-toggle="tab" href="#grades" role="tab" aria-controls="grade"
				aria-selected="false">Grade</a></li>
		</ul>

		<div class="tab-content" id="myTabContent">

			<!--syllabus page-->
			<div class="tab-pane fade show active" id="syllabus" role="tabpanel"
				aria-labelledby="syllabus-tab"></div>

			<!--file page-->

			<div class="tab-pane fade show active" id="file" role="tabpanel"
				aria-labelledby="file-tab"></div>

			<!--assignment detail-->

			<div class="tab-pane fade show active" id="assignment"
				role="tabpanel" aria-labelledby="assignment-tab">

				<div class="container">
					<div class="row notification">
						<div class="col-12 col-md-8 info">

							<div class="alert alert-info" role="alert">
								<h4 class="alert-heading">Assignment 1</h4>
								<p>Page 664 Review Questions: 20.7 20.8 Problems: 20.6,
									20.7, 20.10, 20.13 (Part (a) only), 20.14, 20.16</p>
								<hr>
							</div>
						</div>
						<div class="col-6 col-md-4 ban">

							<ul class="list-group">
								<li class="list-group-item list-group-item-danger"><i
									class="fa fa-warning" style="font-size: 24px"></i> Submission
									constraint</li>
								<li class="list-group-item list-group-item-warning"><i>
								</i>Due time:12/13/2017</li>
								<li class="list-group-item list-group-item-warning"><i>
								</i>Points:100</li>
								<li class="list-group-item list-group-item-warning"><i
									class="material-icons" style="color: red">
										do_not_disturb_alt</i> No resubmit is allowed</li>

								<li class="list-group-item list-group-item-warning"><i
									class="material-icons" style="color: red">do_not_disturb_alt</i>
									Vestibulum at eros</li>
							</ul>
						</div>
					</div>
					<hr>
					<div class="row submission">
						<button type="button" class="btn btn-primary btn-lg btn-block "
							data-toggle="modal" data-target="#exampleModal">Submit</button>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Upload
											File</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form action="/action_page.php">
											<input type="file" name="file" accept="pdf/*">
										</form>
										<br> <br>
										<p>
											<strong>Note:</strong>The file shouldn't exceed 2M<br>
											please use the form(assignmentname+ID)
										</p>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancel</button>
										<button type="button" class="btn btn-success">Submit</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<hr>

				<div class="container submissiondetail">
					<h4>Submission detail</h4>

					<hr>

					<!---------------grading detail------------------->
					<div class="row">

						<a class="btn btn-info" data-toggle="collapse"
							href="#collapseExample" aria-expanded="false"
							aria-controls="collapseExample">Grading detail</a>

						<div class="collapse" id="collapseExample">
							<div class="card card-body">
								Points:30; <br> Review questions 20.7) 5/5. Good 20.8)
								4.5/5. You need to mention it has no importance.15/15.Good
								20.14) . You need to mention about fault tolerance, trusted
								software/hardware and vulnerabilities.
							</div>
						</div>

					</div>
					<!--------------------review/download the submission------------------------->
					<div class="row">
						<button type="button" class="btn btn-light  " data-toggle="modal"
							data-target="#Modal">Review</button>

						<!-- Modal -->
						<div class="modal fade" id="Modal" tabindex="-1" role="dialog"
							aria-labelledby="ModalLabel" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="ModalLabel">Submission detail</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<h1>File to be reviewed</h1>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-success"
											data-dismiss="modal">back</button>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<button type="button" class="btn btn-success ">Download</button>
					</div>
				</div>
			</div>
		</div>

		<!--grades page-->
		<div class="tab-pane fade show active" id="grades" role="tabpanel"
			aria-labelledby="grades-tab">5</div>

	</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	<script src="sty.jsp"></script>
</body>
</html>



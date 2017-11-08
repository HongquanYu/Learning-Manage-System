<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


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
		<a class="navbar-brand" href=""><img src="/resources/background/logo.png"></a>


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

		<!--navigation bar-->
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


			<!-------------------syllabus page---------------------->
			<div class="tab-pane fade show active" id="syllabus" role="tabpanel"
				aria-labelledby="syllabus-tab">

				<div class="container">
					<!--the course information and teacher information-->
					<div class="row courseinfo">
						<div class="col-12 col-sm-6 col-md-8">
							<div class="card">
								<div class="card-header">
									<h4>
										<i class="fa fa-info-circle" style="font-size: 24px"></i>

										Course Description
									</h4>
								</div>
								<div class="card-body">
									<blockquote class="blockquote mb-0">
										<p>Introduction to the Engineering and Computing
											professions, professional ethics. Overview of ECS curricula,
											connections among ECS fields and to the basics of sciences,
											other fields. Basic study, problem solving and other skills
											needed to succeed as an ECS major. Engineering design and
											quantitative methods using MATLAB. Multi-disciplinary team
											projects designed to replicate decision processes in
											real-world situations.</p>

									</blockquote>
								</div>
							</div>
						</div>

						<div class="col-6 col-md-4 teacher">
							<div id="accordion" role="tablist">
								<div class="card">
									<div class="card-header" role="tab" id="headingOne">
										<h5 class="mb-0">
											<a data-toggle="collapse" href="#collapseOne"
												aria-expanded="true" aria-controls="collapseOne"><i
												class="material-icons">perm_identity</i> Teacher Info </a>
										</h5>
									</div>
									<div id="collapseOne" class="collapse show" role="tabpanel"
										aria-labelledby="headingOne" data-parent="#accordion">
										<div class="card-body">
											Email:isososo@umd.edu<br> Linkedin Address:...........<br>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>

					<hr>
					<!--the table and score arrangement-->

					<div class="row scheduleinfo">
						<div class="col-12 col-sm-6 col-md-8">
							<h4>
								<i class="fa fa-file-text-o"></i> Schedule
							</h4>

							<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">Date</th>
										<th scope="col">Info</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">Mon Sep 4, 2017</th>
										<td>Prerequisite knowledge Quiz</td>
									</tr>
									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>
									<tr>
										<th scope="row">Sun Sep 10, 2017</th>
										<td>Use Case Assignment</td>
									</tr>
									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>
									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>
									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>
									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>
									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>

									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>

									<tr>
										<th scope="row">Tue Sep 5, 2017</th>
										<td>Software Engineering Ethics quiz</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!--graph-->
						<div class="col-6 col-md-4 teacher">
							<div class="text-center">
								<img src="/Resource/img/Grade_Distribution_Pie_Chart.png"
									class="distribution" alt="grades">
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--------------assignment page---------------->

			<div class="tab-pane fade show active" id="assignment"
				role="tabpanel" aria-labelledby="assignment-tab">



				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>Hi Emily!</strong> you have <strong>3</strong> assignment
					to do
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>


				<!--arrays-->
				<div class="container container1">


					<h4>
						<i class="material-icons" style="font-size: 36px">assignment</i>Coming
						Assignment
					</h4>
					<hr>


					<div class="row">
						<div class="col">
							<button type="button" class="btn btn-outline-danger"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-danger"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-danger"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-warning"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

						<div class="col">
							<button type="button" class="btn btn-outline-warning"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-warning"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

					</div>


					<div class="row">
						<div class="col">
							<button type="button" class="btn btn-outline-warning"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-warning"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-secondary"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-secondary"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

						<div class="col">
							<button type="button" class="btn btn-outline-secondary"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

					</div>
				</div>


				<!--another arrays-->
				<div class="container contain2">



					<h4>
						<i class="material-icons" style="font-size: 36px">assignment_turned_in</i>Former
						Assignment
					</h4>
					<hr>


					<div class="row">
						<div class="col">
							<button type="button" class="btn btn-outline-success"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-success"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-outline-success"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

						<div class="col">
							<button type="button" class="btn btn-outline-success"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

						<div class="col">
							<button type="button" class="btn btn-outline-success"
								data-toggle="popover" title="Popover title"
								data-content="And here's some amazing content. It's very engaging. Right?">Assignment1</button>
						</div>

					</div>
				</div>
			</div>

			<!--grade page-->
			<div class="tab-pane fade show active" id="grades" role="tabpanel"
				aria-labelledby="grades-tab">

				<div class="row current">
					<div class="col-6 col-md-4 info">
						<div class="alert alert-info" role="alert">
							<h4 class="alert-heading">
								<i class="material-icons" style="font-size: 36px">sentiment_very_satisfied</i>

							</h4>
							<p>Your current score is
							<h4>
								<strong>93%</strong>
							</h4>
							<hr>
						</div>
					</div>
					<div class="col-12 col-sm-6 col-md-8 table">

						<table class="table table-hover">
							<thead class="thead-light">
								<tr>
									<th scope="col"></th>
									<th scope="col"><i class="fa fa-paste"
										style="font-size: 24px"></i> Name</th>
									<th scope="col"><i class="fa fa-pencil"
										style="font-size: 24px"></i>Score</th>
									<th scope="col">Class Average<i class="fa fa-percent"></i>

									</th>
									<th scope="col">Weight<i class="fa fa-percent"></i>

									</th>
									<th scope="col">Category</th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<th scope="row"></th>
									<td>test1</td>
									<td>89/90</td>
									<td>80%</td>
									<td>20%</td>
									<td>Quiz</td>

								</tr>
								<tr>
									<th scope="row"></th>
									<td>test2</td>
									<td>60/90</td>
									<td>80%</td>
									<td>0%</td>
									<td>Quiz</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>test3</td>
									<td>80/90</td>
									<td>70%</td>
									<td>5%</td>
									<td>Quiz</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>test3</td>
									<td>80/90</td>
									<td>70%</td>
									<td>5%</td>
									<td>Quiz</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>test3</td>
									<td>80/90</td>
									<td>70%</td>
									<td>5%</td>
									<td>assignment</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>test3</td>
									<td>80/90</td>
									<td>70%</td>
									<td>5%</td>
									<td>assignment</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>test3</td>
									<td>80/90</td>
									<td>70%</td>
									<td>5%</td>
									<td>assignment</td>
								</tr>
								<tr>
									<th scope="row"></th>
									<td>test3</td>
									<td>80/90</td>
									<td>70%</td>
									<td>5%</td>
									<td>assignment</td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</div>
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



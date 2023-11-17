<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/registerPage.css">
<title>${pageTitle}</title>
</head>
<body>
	<section class="h-100 bg-dark">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card card-registration my-4">
						<div class="row g-0">
							<div class="col-xl-6 d-none d-xl-block">
								<img src="${pageContext.request.contextPath}/resources/images/register-image.webp"
									alt="Sample photo" class="img-fluid" style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
							</div>

							<div class="col-xl-6">
								<div class="card-body p-md-5 text-black">
									<h3 class="mb-5 text-uppercase">Site Registration Form</h3>
									
									<c:if test="${not empty message}">
										<div class="alert alert-success" role="alert">${message}</div>
									</c:if>
									
									<c:if test="${not empty error}">
										<div class="alert alert-danger" role="alert">${error}</div>
									</c:if>
									
									<form action="<%=request.getContextPath()%>/register/user" method="post">
										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<input type="text" id="form3Example1m" name="first_name" class="form-control form-control-lg" />
													<label class="form-label" for="form3Example1m">First name</label>
												</div>
											</div>

											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<input type="text" id="form3Example1n" name="last_name"	class="form-control form-control-lg" />
													<label class="form-label" for="form3Example1n">Last name</label>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<input type="email" id="form3Example1m1" name="email" class="form-control form-control-lg" />
													<label class="form-label" for="form3Example1m1">Email</label>
												</div>
											</div>
											
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<input type="password" id="form3Example1n1" name="password"	class="form-control form-control-lg" />
													<label class="form-label" for="form3Example1n1">Password</label>
												</div>
											</div>
										</div>

										<div class="form-outline mb-4">
											<input type="text" id="form3Example8" name="address" class="form-control form-control-lg" />
											<label class="form-label" for="form3Example8">Address</label>
										</div>

										<div
											class="d-md-flex justify-content-start align-items-center mb-4 py-2">

											<h6 class="mb-0 me-4">Gender:</h6>

											<div class="form-check form-check-inline mb-0 me-4">
												<input class="form-check-input" type="radio" name="gender" id="femaleGender" value="female" />
												<label class="form-check-label" for="femaleGender">Female</label>
											</div>

											<div class="form-check form-check-inline mb-0 me-4">
												<input class="form-check-input" type="radio" name="gender" id="maleGender" value="male" />
												<label class="form-check-label" for="maleGender">Male</label>
											</div>

											<div class="form-check form-check-inline mb-0">
												<input class="form-check-input" type="radio" name="gender" id="otherGender" value="other" />
												<label class="form-check-label" for="otherGender">Other</label>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6 mb-4">
												<select class="select" name="country">
													<option value="">Country</option>													
												</select>
											</div>
											
											<div class="col-md-6 mb-4">
												<select class="select" name="state">
													<option value="">State</option>													
												</select>
											</div>
											
											<div class="col-md-6 mb-4">
												<select class="select" name="city">
													<option value="">City</option>													
												</select>
											</div>
										</div>										

										<div class="form-outline mb-4">
											<input type="text" id="form3Example90" name="pincode" class="form-control form-control-lg" />
											<label class="form-label" for="form3Example90">Pincode</label>
										</div>										

										<div class="d-flex justify-content-end pt-3">
											<button type="reset" class="btn btn-light btn-lg">Reset</button>											
											<button type="submit" class="btn btn-warning btn-lg ms-2">Register</button>
											<a href="<%=request.getContextPath()%>/login" class="btn btn-primary btn-lg ms-2">Back</a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
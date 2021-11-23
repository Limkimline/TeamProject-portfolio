<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" nonce="f9d76f0fbeb54f7ea2a9ea1324a"
	src="//local.adguard.org?ts=1634862422856&amp;type=content-script&amp;dmn=swiperjs.com&amp;app=chrome.exe&amp;css=1&amp;js=1&amp;gcss=1&amp;rel=1&amp;rji=1&amp;sbe=0&amp;stealth=1&amp;uag="></script>
<script type="text/javascript" nonce="f9d76f0fbeb54f7ea2a9ea1324a"
	src="//local.adguard.org?ts=1634862422856&amp;name=AdGuard%20Popup%20Blocker&amp;name=AdGuard%20Extra&amp;type=user-script"></script>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 
Servers의 Tomcat 파일 server.xml의 content 밑에 추가하기 
<Context docBase="D:\fileserver" path="/TestProject/images/" reloadable="true"/> */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none;
}
.span{
		color: red;
	}
ul li {
	list-style-type: none;
}

.loginbar ul>li {
	float: left;
}

nav {
	display: flex;
}
.navbar{
	border-bottom: 1px solid #eee;
}

.container-fluid barList {
	height: 100px;
	backgorund:#FFFFFF;
}

.barList {
	display: flex;
}


.swiper-slide>div {
	display: flex;
}

	.searchbox {
	width: 300px;
	height: 40px;
	border-radius: 22px 22px 22px 22px;
	border: 2px solid #eee;
	box-shadow: 0px 1px 2px 1px gray;
}

.category {
	display: flex;
	justify-content: center;
}

html, body {
	position: relative;
}

body {
	
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	overflow: scroll;
}

ul li {
	list-style-type: none;
	float: left;
}

.card-body ul li {
	width: 100%;
	height: 100%;
}

.swiper {
	width: 100%;
}

section {
	display: flex;
}

.swiper-slide {
	width: 100%;
	height: 100%;
	padding-top:50px;
	text-align: center;
	font-size: 18px;
	background: #fff;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: contain;
}

.swiper {
	margin-left: auto;
	margin-right: auto;
}

.mySwiper {
	display: flex;
	width: 100%;
	height: auto;
}

.swiper-pagination {
	display: flex;
	justify-content: center;
	top: 10px;
	height: 70px;
	padding:0px;
}

.swiper-wrapper {
	display: flex;
	width: 100%;
}

.swiper-pagination-bullet {
	border: 1px solid #eee;
	display: flex;
	border-radius: 5px;
	width: 110px;
	height: 45px;
	justify-content: center;
	line-height: 20px;
	font-size: 14px;
	color: #000;
	opacity: 1;
	font-weight:bold;
	background: rgba(0, 0, 0, 0);
	align-items: center;
}
.interest , .Popularity{
	display:flex;
	justify-content: center;
	width: 100%;
	height: 100%;
}

.swiper-pagination-bullet-active {
	color: #fff;
	background-color:#ff0045;
}
  .logo_img{
            width: 150px;
      }
      
 .lectureul {
	width: 80%;
	height:1200px;
	top:200px;
}
.lecturelist {
	display: flex;
	width: 33%;
	height: 33%;
	display: flex;
	flex-direction: column;
	padding:10px;
}     
      
       .iconSection > input {
                  background-color: #7434eb;
                  color: white;
                  font-weight: 200;
                  border: 1px solid #7434eb;
                  font-size:10px;
                  margin-top: 5px;
                  
            }
            
	.Container{
	
		height:100%;
		display: flex;
        flex-direction: column;
        border: 1px solid #eee;
        border-radius: 5px;
        
	}
	
            .infoSection{
            	 height:50%;
                 display: flex;
                 flex-direction: column;
                justify-content:  space-between;
                
            }
            .infoSection>div{
            	padding:5px 0 0 0;
            	 display: flex;
            	font-size:14px;
            	justify-content: center;
            }
            .imageSection{
           		 display: flex;
                 flex-direction: column;
            	height:50%;
            }
            .imageSection a{
            	height:80%;
            }
            .p{
            	margin: 0 2px 2px 0 ;
            }
            .lectureName{
            	font-size:17px;
            	font-weight: bold ;
            }
            .teachName{
            	color:#999999;
            }
            header{
            	position:fixed;
            	right: 0;
   				top: 0;
   				height:57px;
   				width:100%;
            	z-index:50;
            }
            section{
            	margin-top:67px;
  				
            }
           .mySwiper{
           		float: left;
  				width : 70%;
  				padding: 10px;
  				border: 1px solid #eee;
            	border-radius: 4px;
           }
            .article{
            	float: right;
  				width : 27%;
  				display:flex;
  				flex-direction: column;
  				backgorund:#FFFFFF;
  				border: 1px solid #eee;
            	border-radius: 4px;
            	
            }
            .login_box{
            	height:130px;
            	margin: 5px;
            	padding: 12px 15px 12px;
            	border: 1px solid #eee;
            	border-radius: 4px;
            }
            .login_msg{
            	font-weight: bold;
   	 			font-size: 15px;
    			line-height: 25px;
            }
            .link_login{
            	padding: 8px 0;
            	border-radius: 6px;
            	text-align: center;
            	color:#fff;
            	font-size:13px;
            	background-color: #ff0045;
            	display: block;
            }
            .category{
            	    border: 1px solid #eee;
    				border-radius: 6px;
    				diplay:flex;
    				flex-direction: column;
    				text-align: center;
    				margin:5px;
    				
            }
            .cate_list{
            	display:flex;
            	flex-wrap: wrap;
            	width:100%;
            	text-align: center;
            	margin: 0px;
    			padding:0px;
            }
            .category li{
            	position: relative;
   				width: 47.333%;
   				background-repeat: no-repeat;
   				border: 1px solid #eee;
            }
            .category a{
            	display: block;
  			  	line-height: 30px;
    			padding: 10px 0 9px;
    			color: #111111;
    			font-weight: bold;
            }
            .category a:hover{
            	background-color:#ff0045;
            	color:#fff;
            	font-size:16px;
            }
            .sticky{
            	position:sticky;
            	top: 60px;
            }
            #auto{
            	margin: 5px;
            	width: 100%;
				height: 400px;
            }
        	#auto img{
        		width: 100%;
				height: 400px;
        	}    
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-white">
			<div class="container-fluid barList">
				<div>
					<a href="mainPage"><img class="logo_img" src="image/logo.PNG" alt="로고"></a>
				</div>
				<div>
					<form method="post" action="lecture_name_search?reqPage=1">
						<label> <input type="text" name="lecturename"
							placeholder=" 제목을 입력해주세요" class="searchbox"> <input
							type="submit" value="검색" class="btn btn-primary">
						</label>
					</form>
				</div>

				<c:if test="${member == null}">
					<div class="loginbar">
						<ul>
							<li><a class="nav-link" href="login_init">로그인</a></li>
							<li><a class="nav-link" href="general_qna_list">QnA</a></li>
						</ul>
					</div>
				</c:if>

				<c:if test="${member != null}">
				<div class="loginbar">
					<ul>
						<li><a class="nav-link" href="#">${membername}</a></li>
						<li><a class="nav-link" href="logout">로그아웃</a></li>
						<li><a class="nav-link" href="general_qna_list">QnA</a></li>
						<li><a class="nav-link" href="lectureInfoSearch2">마이페이지</a></li>
						<li><a class="nav-link" href="lecture_input">강의개설</a></li>
						<li><a class="nav-link" href="basket_list?reqPage=1">장바구니</a></li>
					</ul>
				</div>
				</c:if>
			</div>
		</nav>
	</header>
	<section>
		<div class="swiper mySwiper" id="mySwiper">
			<ul class="swiper-pagination">
			</ul>
			<div class="swiper-wrapper">
			
				<div class="swiper-slide">
					<div class="Popularity">
						<ul class="lectureul">
							<c:forEach var="lecture" items="${lectureListPopularity}">
								<li class="lecturelist">
								<div class="Container">
									<div class="imageSection">
										<a href="lecture_clickcountUp?lectureno=${lecture.lectureno}"><img
											src="/TestProject/images/${lecture.imagename}" /></a>
										<div class="iconSection">
                       						<input type="button" value="오리지널 VOD">
                 						 </div>
								</div>
								<div class="infoSection">
										<div class="lectureName">${lecture.name}</div>
										<div class="teachName">강사: ${lecture.username}</div>
							
										<div class="lecturedate">강의 기간<br> ${lecture.startdate} ~ ${lecture.enddate}</div>
										<div class="lecturetime">강의 시간<br> ${lecture.starttime} ~ ${lecture.endtime}</div>
										<div class="lectureClikc"><img src="image/클릭.jpg" style="width:30px; height:30px"><p class="p">${lecture.clickcount}</p></div>
									</div>
								</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				
				<c:forEach var="ListInList" items="${ListInList}" varStatus="status">
				<div class="swiper-slide">
						<div class="interest int${status.count}">
							<ul class="lectureul">
								<c:forEach var="lecture" items="${ListInList}">
									<li class="lecturelist">
										<div class="Container">
									<div class="imageSection">
										<a href="lecture_clickcountUp?lectureno=${lecture.lectureno}"><img
											src="/TestProject/images/${lecture.imagename}" /></a>
										<div class="iconSection">
                       						<input type="button" value="오리지널 VOD">
                 						 </div>
								</div>
								<div class="infoSection">
										<div class="lectureName">${lecture.name}</div>
										<div class="teachName">강사: ${lecture.username}</div>
							
										<div class="lecturedate">강의 기간<br> ${lecture.startdate} ~ ${lecture.enddate}</div>
										<div class="lecturetime">강의 시간<br> ${lecture.starttime} ~ ${lecture.endtime}</div>
										<div class="lectureClikc"><img src="image/클릭.jpg" style="width:30px; height:30px"><p class="p">${lecture.clickcount}</p></div>
									</div>
								</div>

									</li>
								</c:forEach>
							</ul>
						</div>
				</div>
				</c:forEach>
				<c:if test="${member != null}">
				<div class="swiper-slide">
					<div class="Popularity">
						<ul class="lectureul">
							<c:forEach var="lecture" items="${lectureListInterest}">
								<li class="lecturelist">
										<div class="Container">
									<div class="imageSection">
										<a href="lecture_clickcountUp?lectureno=${lecture.lectureno}"><img
											src="/TestProject/images/${lecture.imagename}" /></a>
										<div class="iconSection">
                       						<input type="button" value="오리지널 VOD">
                 						 </div>
								</div>
								<div class="infoSection">
										<div class="lectureName">${lecture.name}</div>
										<div class="teachName">강사: ${lecture.username}</div>
							
										<div class="lecturedate">강의 기간 <br>${lecture.startdate} ~ ${lecture.enddate}</div>
										<div class="lecturetime">강의 시간 <br> ${lecture.starttime} ~ ${lecture.endtime}</div>
										<div class="lectureClikc"><img src="image/클릭.jpg" style="width:30px; height:30px"><p class="p">${lecture.clickcount}</p></div>
									</div>
								</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				</c:if>
			</div>
			
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		
		</div>
		<div class="article">
			<div class="category">
				<div>
					<h6><b>카테고리별 전체 강의 보기</b></h6>
				</div>
				<ul class="cate_list">
					<c:forEach var="interest" items="${interestList}" varStatus="status">
						<li><a href="lecture_interest_search?int_no=${interest.int_no}&reqPage=1">${interest.int_name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="sticky">
				<c:if test="${member == null}">
					<div class="login_box">
						<p class="login_msg">"로그인 하시고 구잉의
						다양한 강의를 만나보세요."</p>
						<a href="login_init" class="link_login">구잉 로그인</a>
					</div>
				</c:if>
			
				<c:if test="${member != null}">
				<div class="login_box">
					<p class="login_msg">"구잉의
					다양한 강의를 만나보세요."</p>
					<a href="logout" class="link_login">구잉 로그아웃</a>
				</div>
				</c:if>
				<div class="swiper mySwiper" id="auto">
     			 <div class="swiper-wrapper">
       				<div class="swiper-slide"><img src="https://i.pinimg.com/736x/f9/2a/83/f92a83848461b2cc2e7962f4a5fc70a2.jpg" /></div>
       				<div class="swiper-slide"><img src="https://i.pinimg.com/236x/1b/e1/d6/1be1d6014f441bb8682561870a3e212a.jpg" /></div>
       				<div class="swiper-slide"><img src="data:image/png;base64,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" /></div>
        			<div class="swiper-slide"><img src="data:image/jpeg;base64,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" /></div>
			      </div>
      			<div class="swiper-button-next"></div>
      			<div class="swiper-button-prev"></div>
      			
    			</div>
			
			</div>
	</div>	
	</section>
	
	<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper("#mySwiper", {
			slidesPerView : 1,
			spaceBetween : 30,
			loop : true,
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
				renderBullet : function(index, className) {

					return ('<li class="' + className + " " + "interest"
							+ (index + 1) + '"></li>');
					// return '<span class="' + className + '">' + (index + 1) + "</span>";
				}
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
		var List1 = document.querySelector("li.interest1");
		List1.innerHTML = "인기 강의";
		var count=2;
		<c:forEach var="interest" items="${interestList}" varStatus="status">
		var Interest = "${interest.int_name}";
		var List = document.querySelector("li.interest${status.count+1}");
		List.innerHTML = "${interest.int_name}";
		count=count+1;
		</c:forEach>
		
		var swiper = new Swiper("#auto", {
	        spaceBetween: 30,
	        centeredSlides: true,
	        autoplay: {
	          delay: 10000,
	          disableOnInteraction: false,
	        },
	       
	        navigation: {
	          nextEl: ".swiper-button-next",
	          prevEl: ".swiper-button-prev",
	        },
	      });
		
		if ("${member}"!=null) {
			var List2 = document.querySelector("li.interest"+count);
			List2.innerHTML = "관심 강의 추천";
		}
		
		
	</script>
</body>
</html>
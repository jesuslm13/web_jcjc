<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html class="fluid">
<head>
<meta charset="UTF-8">
<title>정치정치</title>
	<!-- Bootsrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="<%=root%>/css/main.css">
    <!-- FontAwesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
        integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="<%=root%>/js/echarts.min.js"></script>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=068c3dd6105c7bf6bb9b92b8a723997c"></script>
	
</head>
<body class="fluid">

<!-- header -->
<div class="fixed-top">
	<jsp:include page="/WEB-INF/view/header/title.jsp" flush="true"/>
    <jsp:include page="/WEB-INF/view/header/menu.jsp" flush="true"/>
</div>

<!-- body -->
<div class="w-100 h-100 d-flex align-items-center">
	<div class="w-100 h-100 p-0 m-0">
		<%-- <div class="row justify-content-center">
			<a href="<%=root%>/politician/prediction.do?politician_no=0">
				<img src="<%=root%>/img/map_kor.png" alt="지역선택" class="img-fluid">
			</a>
		</div>
		<div class="row justify-content-center">
			<p>지역을 선택해주세요.</p>
		</div> --%>


			<div id="map" style="width: 100%; height: 100%;"></div>



			<script>
			 
			//행정구역 구분
			$.getJSON("<%=root%>/db/seoul_geo.json", function(geojson) {
			 
			    var data = geojson.features;
			    var coordinates = [];    //좌표 저장할 배열
			    var name = '';            //행정 구 이름
			 
			    $.each(data, function(index, val) {
			 
			        coordinates = val.geometry.coordinates;
			        name = val.properties.name;
			        
			        displayArea(coordinates, name);
			 
			    })
			})
						
			
			var polygons=[];                //function 안 쪽에 지역변수로 넣으니깐 폴리곤 하나 생성할 때마다 배열이 비어서 클릭했을 때 전체를 못 없애줌.  그래서 전역변수로 만듦.
			    
			//행정구역 폴리곤
			function displayArea(coordinates, name) {
			 
			    var path = [];            //폴리곤 그려줄 path
			    var points = [];        //중심좌표 구하기 위한 지역구 좌표들
			    
			    $.each(coordinates[0], function(index, coordinate) {        //console.log(coordinates)를 확인해보면 보면 [0]번째에 배열이 주로 저장이 됨.  그래서 [0]번째 배열에서 꺼내줌.
			        var point = new Object(); 
			        point.x = coordinate[1];
			        point.y = coordinate[0];
			        points.push(point);
			        path.push(new daum.maps.LatLng(coordinate[1], coordinate[0]));            //new daum.maps.LatLng가 없으면 인식을 못해서 path 배열에 추가
			    })
			    
			    // 다각형을 생성합니다 
			    var polygon = new daum.maps.Polygon({
			        map : map, // 다각형을 표시할 지도 객체
			        path : path,
			        strokeWeight : 1,
			        strokeColor : '#004c80',
			        strokeOpacity : 1.0,
			        fillColor : '#fff',
			        fillOpacity : 0.7
			    });
			    
			    var dong = new daum.maps.CustomOverlay({
			        map: map,
			        clickable: false,
			        content: '<p class="m-0">' + name + '</p>',
			        position: centroid(points),
			        xAnchor: 0.5,
			        yAnchor: 1,
			        zIndex: 3
			    }); 
			    dong.setMap(map);
			    polygons.push(polygon);            //폴리곤 제거하기 위한 배열
			 
			    // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다 
			    // 지역명을 표시하는 커스텀오버레이를 지도위에 표시합니다
			    daum.maps.event.addListener(polygon, 'mouseover', function(mouseEvent) {
			         polygon.setOptions({
			            fillColor : '#09f'
			        });
			    });
			 
			    // 다각형에 mousemove 이벤트를 등록하고 이벤트가 발생하면 커스텀 오버레이의 위치를 변경합니다 
			    daum.maps.event.addListener(polygon, 'mousemove', function(mouseEvent) {
					//
			    });
			 
			    // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다
			    // 커스텀 오버레이를 지도에서 제거합니다 
			    daum.maps.event.addListener(polygon, 'mouseout', function() {
			        polygon.setOptions({
			            fillColor : '#fff'
			        });
			    });
			 
			    // 다각형에 click 이벤트를 등록하고 이벤트가 발생하면 해당 지역 확대을 확대합니다.
			    daum.maps.event.addListener(polygon, 'click', function() {
			        // 현재 지도 레벨에서 2레벨 확대한 레벨
			        var level = 5; //map.getLevel()-2;
			        
			        // 지도를 클릭된 폴리곤의 중앙 위치를 기준으로 확대합니다
			        map.setLevel(level, 
			        		{ anchor: centroid(points),
			        		animate: {duration: 120} }            //확대 애니메이션 시간
			        );
			        
			        map.panTo(centroid(points));
			    });
			}
			
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = { 
			        center: new daum.maps.LatLng(37.5642135, 127.0016985), // 지도의 중심좌표
			        level: 7 // 지도의 확대 레벨
			    };
			
			var map = new daum.maps.Map(mapContainer, mapOption),
			    customOverlay = new daum.maps.CustomOverlay({}),
			    infowindow = new daum.maps.InfoWindow({removable: true});
			
			/*
			// 지도에 영역데이터를 폴리곤으로 표시합니다 
			for (var i = 0, len = areas.length; i < len; i++) {
			    displayArea(areas[i]);
			}
			*/
			
			//centroid 알고리즘 (폴리곤 중심좌표 구하기 위함)
			function centroid (points) {
			    var i, j, len, p1, p2, factor, area, x, y;
			 
			    area = x = y = 0;
			 
			    for (i = 0, len = points.length, j = len - 1; i < len; j = i++) {
			            p1 = points[i];
			            p2 = points[j];
			 
			            factor = p1.x * p2.y - p2.x * p1.y;
			            x += (p1.x + p2.x) * factor;
			            y += (p1.y + p2.y) * factor;
			            area += factor * 3;
			    }
			    x = x/area - 0.001;
			    y = y/area;
			    return new daum.maps.LatLng(x, y);
			}

			
			</script>



		</div>
</div>
</body>
</html>
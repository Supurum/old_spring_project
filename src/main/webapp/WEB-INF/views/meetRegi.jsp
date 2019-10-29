<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="include/header.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
<!DOCTYPE html>
<html>
<head>
<style>
    .map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
	.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
	.map_wrap {position:relative;width:100%;height:500px;}
	#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
	.bg_white {background:#fff;}
	#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
	#menu_wrap .option{text-align: center;}
	#menu_wrap .option p {margin:10px 0;}  
	#menu_wrap .option button {margin-left:5px;}
	#placesList li {list-style: none;}
	#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
	#placesList .item span {display: block;margin-top:4px;}
	#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	#placesList .item .info{padding:10px 0 10px 55px;}
	#placesList .info .gray {color:#8a8a8a;}
	#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
	#placesList .info .tel {color:#009900;}
	#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
	#placesList .item .marker_1 {background-position: 0 -10px;}
	#placesList .item .marker_2 {background-position: 0 -56px;}
	#placesList .item .marker_3 {background-position: 0 -102px}
	#placesList .item .marker_4 {background-position: 0 -148px;}
	#placesList .item .marker_5 {background-position: 0 -194px;}
	#placesList .item .marker_6 {background-position: 0 -240px;}
	#placesList .item .marker_7 {background-position: 0 -286px;}
	#placesList .item .marker_8 {background-position: 0 -332px;}
	#placesList .item .marker_9 {background-position: 0 -378px;}
	#placesList .item .marker_10 {background-position: 0 -423px;}
	#placesList .item .marker_11 {background-position: 0 -470px;}
	#placesList .item .marker_12 {background-position: 0 -516px;}
	#placesList .item .marker_13 {background-position: 0 -562px;}
	#placesList .item .marker_14 {background-position: 0 -608px;}
	#placesList .item .marker_15 {background-position: 0 -654px;}
	#pagination {margin:10px auto;text-align: center;}
	#pagination a {display:inline-block;margin-right:10px;}
	#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
<meta charset="UTF-8">
<title>title</title>

</head>
<body>

<c:if test="${sessionScope.id != null }">
<div class="container">
	<div class="row">
      <div class="col-md-7 col-md-offset-2">
        <div class="well well-sm">
          <fieldset>
            <legend class="text-center">글 작성</legend>
            <div>
              <label class="col-md-3 control-label" for="name" >제목</label>
              <div class="col-md-9">
                <input type="text" id="meet_name" class="form-control" size ='50'>
              </div>
            </div>
    		<div>
            	 <label class="col-md-3 control-label" for="name" >지역</label>
            	<select id="meet_addr">
            		<option value="1" selected>강서구
            		<option value="2">금정구
            		<option value="3">기장군
            		<option value="4">남구
            		<option value="5">동구
            		<option value="6">동래구
            		<option value="7">부산진구
            		<option value="8">북구
            		<option value="9">사상구
            		<option value="10">사하구
            		<option value="11">서구
            		<option value="12">수영구
            		<option value="13">연제구
            		<option value="14">영도구
            		<option value="15">중구
            		<option value="16">해운대구
            	</select>
            </div><br/>
                 
                 
                           
          	<div>
            	 <label class="col-md-3 control-label" for="name" >만남 종류 </label>
            	<select id="meet_category">
            		<option value="1" selected>짧은 만남
            		<option value="2">긴 만남 
            		<option value="3">랜덤 만남 
            		<option value="4">단체 만남 
            	
            	</select>
            </div><br/>
 
                        
           <div>
           	<label class="col-md-3 control-label" for="name" >서브 카테고리(짧은 만남 선택자)</label>
            	<select id="meet_sub_category">
            		<option value="1" selected>술
            		<option value="2">영화
            		<option value="3">맛집
            		<option value="4">헬스
            		<option value="5">조깅
            		<option value="6">등산
            	
            		
            	</select>
            </div><br/>
            <div class="maxNum" style="visibility:hidden">
            	<label class="col-md-3 control-label" for="name" >최대 인원수</label>
            		<select id="meet_maxpeoplenum">
            			<c:forEach begin="1" end="30" var="v">
            				<option value="${v}">${v}
            			</c:forEach>
            		</select>
            </div><br/>
            <label class="col-md-3 control-label" for="name" >만날장소</label>
            <br/>
            
            <div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    			<div id="menu_wrap" class="bg_white">
        <div class="option">
        
            <div>
                    키워드 : <input type="text" value="서면 맛집" id="keyword" size="15"> 
                    <button type="button" id="btnSearch">검색하기</button> 
            </div>
           
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
			</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a590d83cd670c0f87fcdb7e9e8dfc29&libraries=services"></script>
<script>
			/* var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new daum.maps.LatLng(35.15760135358475,129.0591815420209), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  
			
			// 지도를 생성합니다    
			var map = new daum.maps.Map(mapContainer, mapOption); 
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new daum.maps.services.Geocoder();
			
			var marker = new daum.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
			    infowindow = new daum.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다
			
			// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
			searchAddrFromCoords(map.getCenter(), displayCenterInfo);
			
			// 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
			daum.maps.event.addListener(map, 'click', function(mouseEvent) {
				
				var latlng = mouseEvent.latLng; 
				var lat = latlng.getLat();
				var lng = latlng.getLng();
	            
				console.log(lat)
				console.log(lng)
			    searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
			        if (status === daum.maps.services.Status.OK) {
			            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
			            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
			            
			            var content = '<div class="bAddr">' +
			                            '<span class="title">법정동 주소정보</span>' + 
			                            detailAddr + 
			                        '</div>';
			
			            // 마커를 클릭한 위치에 표시합니다 
			            marker.setPosition(mouseEvent.latLng);
			            marker.setMap(map);
			
			            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
			            infowindow.setContent(content);
			            infowindow.open(map, marker);
			            
			            
			        }   
			    });
			});
			
			// 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
			daum.maps.event.addListener(map, 'idle', function() {
			    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
			});
			
			function searchAddrFromCoords(coords, callback) {
			    // 좌표로 행정동 주소 정보를 요청합니다
			    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
			}
			
			function searchDetailAddrFromCoords(coords, callback) {
			    // 좌표로 법정동 상세 주소 정보를 요청합니다
			    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
			}
			
			// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
			function displayCenterInfo(result, status) {
			    if (status === daum.maps.services.Status.OK) {
			        var infoDiv = document.getElementById('centerAddr');
			
			        for(var i = 0; i < result.length; i++) {
			            // 행정동의 region_type 값은 'H' 이므로
			            if (result[i].region_type === 'H') {
			                infoDiv.innerHTML = result[i].address_name;
			                break;
			            }
			        }
			    }    
			} */
			
			var markers = [];

			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  

			// 지도를 생성합니다    
			var map = new daum.maps.Map(mapContainer, mapOption); 

			// 장소 검색 객체를 생성합니다
			var ps = new daum.maps.services.Places();  

			// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({zIndex:1});

			// 키워드로 장소를 검색합니다
			searchPlaces();

			// 키워드 검색을 요청하는 함수입니다
			function searchPlaces() {
				

			    var keyword = document.getElementById('keyword').value;

			    if (!keyword.replace(/^\s+|\s+$/g, '')) {
			        alert('키워드를 입력해주세요!');
			        return false;
			    }

			    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
			    ps.keywordSearch( keyword, placesSearchCB); 
			}

			// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
			function placesSearchCB(data, status, pagination) {
			    if (status === daum.maps.services.Status.OK) {

			        // 정상적으로 검색이 완료됐으면
			        // 검색 목록과 마커를 표출합니다
			        displayPlaces(data);

			        // 페이지 번호를 표출합니다
			        displayPagination(pagination);

			    } else if (status === daum.maps.services.Status.ZERO_RESULT) {

			        alert('검색 결과가 존재하지 않습니다.');
			        return;

			    } else if (status === daum.maps.services.Status.ERROR) {

			        alert('검색 결과 중 오류가 발생했습니다.');
			        return;

			    }
			}

			// 검색 결과 목록과 마커를 표출하는 함수입니다
			function displayPlaces(places) {

			    var listEl = document.getElementById('placesList'), 
			    menuEl = document.getElementById('menu_wrap'),
			    fragment = document.createDocumentFragment(), 
			    bounds = new daum.maps.LatLngBounds(), 
			    listStr = '';
			    
			    // 검색 결과 목록에 추가된 항목들을 제거합니다
			    removeAllChildNods(listEl);

			    // 지도에 표시되고 있는 마커를 제거합니다
			    removeMarker();
			    
			    for ( var i=0; i<places.length; i++ ) {

			        // 마커를 생성하고 지도에 표시합니다
			        var placePosition = new daum.maps.LatLng(places[i].y, places[i].x),
			            marker = addMarker(placePosition, i), 
			            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

			        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
			        // LatLngBounds 객체에 좌표를 추가합니다
			        bounds.extend(placePosition);

			        // 마커와 검색결과 항목에 mouseover 했을때
			        // 해당 장소에 인포윈도우에 장소명을 표시합니다
			        // mouseout 했을 때는 인포윈도우를 닫습니다
			        (function(marker, title) {
			            daum.maps.event.addListener(marker, 'mouseover', function() {
			                displayInfowindow(marker, title);
			            });

			            daum.maps.event.addListener(marker, 'mouseout', function() {
			                infowindow.close();
			            });

			            itemEl.onmouseover =  function () {
			                displayInfowindow(marker, title);
			            };

			            itemEl.onmouseout =  function () {
			                infowindow.close();
			            };
			        })(marker, places[i].place_name);

			        fragment.appendChild(itemEl);
			    }

			    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
			    listEl.appendChild(fragment);
			    menuEl.scrollTop = 0;

			    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
			    map.setBounds(bounds);
			}

			// 검색결과 항목을 Element로 반환하는 함수입니다
			function getListItem(index, places) {

			    var el = document.createElement('li'),
			    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
			                '<div class="info">' +
			                '   <h5>' + places.place_name + '</h5>';

			    if (places.road_address_name) {
			        itemStr += '    <span>' + places.road_address_name + '</span>' +
			                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
			    } else {
			        itemStr += '    <span>' +  places.address_name  + '</span>'; 
			    }
			                 
			      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
			                '</div>';           

			    el.innerHTML = itemStr;
			    el.className = 'item';

			    return el;
			}

			// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
			function addMarker(position, idx, title) {
			    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
			        imageSize = new daum.maps.Size(36, 37),  // 마커 이미지의 크기
			        imgOptions =  {
			            spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
			            spriteOrigin : new daum.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
			            offset: new daum.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
			        },
			        markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imgOptions),
			            marker = new daum.maps.Marker({
			            position: position, // 마커의 위치
			            image: markerImage 
			        });

			    marker.setMap(map); // 지도 위에 마커를 표출합니다
			    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

			    return marker;
			}

			// 지도 위에 표시되고 있는 마커를 모두 제거합니다
			function removeMarker() {
			    for ( var i = 0; i < markers.length; i++ ) {
			        markers[i].setMap(null);
			    }   
			    markers = [];
			}

			// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
			function displayPagination(pagination) {
			    var paginationEl = document.getElementById('pagination'),
			        fragment = document.createDocumentFragment(),
			        i; 

			    // 기존에 추가된 페이지번호를 삭제합니다
			    while (paginationEl.hasChildNodes()) {
			        paginationEl.removeChild (paginationEl.lastChild);
			    }

			    for (i=1; i<=pagination.last; i++) {
			        var el = document.createElement('a');
			        el.href = "#";
			        el.innerHTML = i;

			        if (i===pagination.current) {
			            el.className = 'on';
			        } else {
			            el.onclick = (function(i) {
			                return function() {
			                    pagination.gotoPage(i);
			                }
			            })(i);
			        }

			        fragment.appendChild(el);
			    }
			    paginationEl.appendChild(fragment);
			}

			// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
			// 인포윈도우에 장소명을 표시합니다
			function displayInfowindow(marker, title) {
			    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

			    infowindow.setContent(content);
			    infowindow.open(map, marker);
			}

			 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
			function removeAllChildNods(el) {   
			    while (el.hasChildNodes()) {
			        el.removeChild (el.lastChild);
			    }
			}		
</script>
			
              <div class="col-md-12 text-right">
                <input type="button" id="btnCommit" class="btn btn-primary btn-lg" value="작성완료"/>
              </div>
          </fieldset>
        </div>
      </div>
	</div>
</div>
</c:if>
<script>
$(document).ready(function(){
	var session = '${sessionScope.id}';
	if(session==null || session==""){
		alert('로그인후이용가능한페이지입니다.')
		location.href = "/login";
	}
	$('#btnCommit').click(function(){
		var meet_addr = $('#meet_addr').val();
		var meet_name = $('#meet_name').val();
		var meet_category = $('#meet_category').val();
		var meet_sub_category = $('#meet_sub_category').val();
		var meet_place = $('#keyword').val();
		var meet_maxpeoplenum = $('#meet_maxpeoplenum').val();
		url = "/meetRegiCommit";
		data = {
			'meet_addr' : meet_addr,
			'meet_name' : meet_name,
			'meet_category' : meet_category,
			'meet_sub_category' : meet_sub_category,
			'meet_place' : meet_place,
			'meet_maxpeoplenum'	: meet_maxpeoplenum
		};
		$.post(url,data,function(entity){
			if(entity=='SUCESSS'){
				alert('처리가완료되었습니다.');
				location.href="/ath/selectAll";
			}else if(entity=='FAIL'){
				alert('등록신청이되있는매칭이존재합니다.');
			}else{
				alert('오류발생');
			}
		});
	});
	$('#meet_category').change(function(){ 
		var val = $(this).val();
		// 단체만남인 경우
		if (val == 4) {			
			$('.maxNum').attr("style", "visibility:visible");
		} 
		else {
			$('.maxNum').attr("style", "visibility:hidden");
		};
	});
	$('#btnSearch').click(function(){ 
		searchPlaces();
	});
});
</script>
</body>
</html>
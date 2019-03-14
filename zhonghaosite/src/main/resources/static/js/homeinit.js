function bannerInit(bannerList){
    var banner_div = document.getElementById("banner_div");
    var innerText = '';
    for (var i=0; i<bannerList.length; i++){
        // alert("yes");
        var text =
            '             <div class="slide-item" style="background-image: url('+ bannerList[i].imgPath +');">\n' +
            '                <div class="auto-container">\n' +
            '                    <div class="content-box">\n' +
            '                        <h3>' + bannerList[i].title1 + '</h3>\n' +
            '                        <h2>'+ bannerList[i].title2 +'</h2>\n' +
            '                        <div class="text">' + bannerList[i].title3 + '</div>\n' +
            '                        <div class="link-box">\n' +
            '                            <a href="about.html" class="theme-btn btn-style-one">Read More <i class="flaticon-right-arrow"></i></a>\n' +
            '                        </div>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n';
        innerText += text;
    }
    banner_div.innerHTML = innerText;
}

function featuresInit(featuresList) {
    var features_row = document.getElementById("features_row");
    var innerText = '';
    for (var i=0; i<featuresList.length; i++){
        var text =
            '                <div class="feature-block col-lg-4 col-md-6 col-sm-12 wow fadeInLeft" data-wow-delay="' + i*400 + 'ms">\n' +
            '                    <div class="inner-box">\n' +
            '                        <div class="image-box">\n' +
            '                            <figure class="image"><a href="services.html"><img src="' + featuresList[i].imgPath + '" alt=""></a></figure>\n' +
            '                        </div>\n' +
            '                        <div class="caption-box">\n' +
            '                            <h3><a href="service-single.html">'+ featuresList[i].title +'</a></h3>\n' +
            '                            <div class="text">' + featuresList[i].text + '</div>\n' +
            '                        </div>\n' +
            '                    </div>\n' +
            '                </div>\n';
        innerText += text;
    }
    features_row.innerHTML = innerText;
}

function chartInit(chartInfo){
    var chart_row = document.getElementById("chart_row");
    var text =
        ' <!-- Content Columnt -->\n' +
        '                <div class="content-column col-lg-6 col-md-12 col-sm-12">\n' +
        '                    <div class="inner-column">\n' +
        '                        <div class="sec-title wow fadeInLeft" data-wow-delay="0ms">\n' +
        '                            <h2>' + chartInfo.title + '</h2>\n' +
        '                        </div>\n' +
        '                        <div class="text wow fadeInLeft" data-wow-delay="300ms">' + chartInfo.text + '</div>\n' +
        '                        <div class="link-box wow fadeInLeft" data-wow-delay="600ms"><a href="about.html" class="theme-btn btn-style-two">VIEW STATS <i class="flaticon-right-arrow"></i></a></div>\n' +
        '                    </div>\n' +
        '                </div>\n' +
        '\n' +
        '                <!-- Graph Column -->\n' +
        '                <div class="graph-column col-lg-6 col-md-12 col-sm-12 wow fadeIn">\n' +
        '                    <div class="inner-column wow fadeInRight" data-wow-delay="900ms">\n' +
        '                        <figure class="graph-image"><img src="' + chartInfo.imgPath + '" alt=""></figure>\n' +
        '                    </div>\n' +
        '                </div>';
    chart_row.innerHTML = text;

}

function servicesInit(serviceList){
    var services_row = document.getElementById("services_row");
    var innerText = '';
    // alert(serviceList.length);
    for (var i=0; i<serviceList.length; i++){
        var text =
            '<!-- Service Block -->\n' +
            '                        <div class="service-block col-lg-6 col-md-6 col-sm-12 wow fadeIn" data-wow-delay="' + (i+1)*300 + 'ms">\n' +
            '                            <div class="inner-box">\n' +
            '                                <div class="icon-box"><span class="icon flaticon-toy"></span></div>\n' +
            '                                <h3>' + serviceList[i].title + '</h3>\n' +
            '                                <div class="content-box">\n' +
            '                                    <div class="inner">\n' +
            '                                        <div class="text">' + serviceList[i].text + '</div>\n' +
            '                                        <a href="service-single.html" class="read-more">Read more <i class="flaticon-right-arrow"></i></a>\n' +
            '                                    </div>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                        </div>\n';
        innerText += text;
    }
    services_row.innerHTML = innerText;
}
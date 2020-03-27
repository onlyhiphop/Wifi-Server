var drawChart = {
    // 画一个柱状图
    initBar: function(element, data, seriesName){
        var myChart = echarts.init(element);
        var dataSeries = data[1];
        var xdata = data[0];

        var option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            xAxis: {
                type: 'category',
                data: xdata,
                axisTick: {
                    alignWithLabel: true
                }
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                name: seriesName,
                data: dataSeries,
                type: 'bar',
                showBackground: true,
                backgroundStyle: {
                    color: 'rgba(220, 220, 220, 0.8)'
                }
            }]
        };

        myChart.setOption(option);
    },

    // 画一个饼图
    initPie: function(element,data, title){

        var dataSeries = data;

        var myChart = echarts.init(element);
        var option = {
            legend: {},
            title: {
                text: title,
                subtext: '教学区域',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
                type: 'scroll',
                orient: 'vertical',
                right: 10,
                top: 20,
                bottom: 20,
                data: dataSeries,
                selected: dataSeries
            },
            series: [
                {
                    name: '地点',
                    type: 'pie',
                    radius: '55%',
                    center: ['40%', '50%'],
                    data: dataSeries,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        }
        myChart.setOption(option)
    },

    // 画一个梯形折线图
    initLine: function(element, data){
        var myChart = echarts.init(element);
        var option = {
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['20:00 ~ 05:00 手机使用情况']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                data: ['23:00', '24:00', '01:00', '02:00', '03:00', '04:00', '05:00']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '次数',
                    type: 'line',
                    step: 'middle',
                    data: data
                }
            ]
        };
        myChart.setOption(option);
    },

    // 画一个双柱状图
    initTowBar: function(element, data, count){
        console.log(data);
        var seriesCount = [];
        for(var i = 0; i < count; i++){
            seriesCount.push({type: 'bar'})
        }
        var myChart = echarts.init(element);
        var option = {
            legend: {},
            tooltip: {},
            dataset: {
                source: data
            },
            xAxis: {type: 'category'},
            yAxis: {},
            // Declare several bar series, each will be mapped
            // to a column of dataset.source by default.
            series: seriesCount
        };

        myChart.setOption(option);
        
    },

    // 画一个双折线图
    initTowLine: function(element, data){
        var myChart = echarts.init(element);
        var option = {
            title: {
                text: '折线图堆叠'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['访问次数', '班级平均访问次数', '访问时间', '班级平均访问时间']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '访问次数',
                    type: 'line',
                    stack: '总量',
                    data: data.count
                },
                {
                    name: '班级平均访问次数',
                    type: 'line',
                    stack: '总量',
                    data: [220, 182, 191, 234, 290, 330, 310]
                },
                {
                    name: '访问时间',
                    type: 'line',
                    stack: '总量',
                    data: data.time
                },
                {
                    name: '班级平均访问时间',
                    type: 'line',
                    stack: '总量',
                    data: [320, 332, 301, 334, 390, 330, 320]
                }
            ]
        };
        myChart.setOption(option);
    },

    // 画一个热力图
    initHotMap: function(element){
        var myChart = echarts.init(element);
        var geoCoordMap = {
            'p1':[113.331788,23.121235],
            'p2':[113.332788,23.121335],
            'p3':[113.330188,23.122135],
            'p4':[113.33128,23.123135],
            'p5':[113.33104,23.120135],
            'p6':[113.3342,23.1222135],
            'p7':[113.3333,23.1235],
            'p8':[113.332288,23.124435],
            'p9':[113.334588,23.120035],
            'p10':[113.333288,23.119935],
            'p11':[113.335688,23.11835],
            'p12':[113.337888,23.1210135],
            'p13':[113.330188,23.121935],
            'p14':[113.329088,23.120135],
            'p15':[113.333988,23.120035],
            'p16':[113.331588,23.122235],
            'p17':[113.331688,23.121335],
            'p18':[113.333388,23.124435],
            'p19':[113.334488,23.125535],
            'p20':[113.335588,23.123335],
            'p21':[113.331788,23.121235],
            'p22':[113.332788,23.121335],
            'p23':[113.330188,23.122135],
            'p24':[113.33128,23.123135],
            'p25':[113.33104,23.120135],
            'p26':[113.3342,23.1222135],
            'p27':[113.3333,23.1235],
            'p28':[113.332288,23.124435],
            'p29':[113.334588,23.120035],
            'p30':[113.333288,23.119935],
            'p31':[113.335688,23.11835],
            'p32':[113.337888,23.1210135],
            'p33':[113.330188,23.121935],
            'p34':[113.329088,23.120135],
            'p35':[113.333988,23.120035],
            'p36':[113.331588,23.122235],
            'p37':[113.331688,23.121335],
            'p38':[113.333388,23.124435],
            'p39':[113.334488,23.125535],
            'p40':[113.335588,23.123335]
            };
        var value = [
        {name:'p1',value:100},
        {name:'p2',value:120},
        {name:'p3',value:130},
        {name:'p4',value:122},
        {name:'p5',value:144},
        {name:'p6',value:100},
        {name:'p7',value:156},
        {name:'p8',value:199},
        {name:'p9',value:122},
        {name:'p10',value:100},
        {name:'p11',value:140},
        {name:'p12',value:140},
        {name:'p13',value:143},
        {name:'p14',value:199},
        {name:'p15',value:111},
        {name:'p16',value:133},
        {name:'p17',value:155},
        {name:'p18',value:135},
        {name:'p19',value:210},
        {name:'p20',value:229},
        {name:'p21',value:100},
        {name:'p22',value:120},
        {name:'p23',value:130},
        {name:'p24',value:122},
        {name:'p25',value:144},
        {name:'p26',value:100},
        {name:'p27',value:156},
        {name:'p28',value:199},
        {name:'p29',value:122},
        {name:'p30',value:100},
        {name:'p31',value:100},
        {name:'p32',value:120},
        {name:'p33',value:130},
        {name:'p34',value:122},
        {name:'p35',value:144},
        {name:'p36',value:100},
        {name:'p37',value:156},
        {name:'p38',value:199},
        {name:'p39',value:122},
        {name:'p40',value:100}
        ];
            
        var convertData = function (data,n) {
            var res = [];
            for (var i = 0; i < data.length; i++) {
                var geoCoord = geoCoordMap[data[i].name];
                if (geoCoord) {
                    res.push(geoCoord.concat(data[i].value+ (Math.random()-0.5)*n ));
                }
            }
            return res;
        };
            
        var option = {
            baseOption: {
                title:{
                    text: "区域人群实时密度监控--花城广场",
                    link: 'http://blog.csdn.net/yc_1993',
                    subtext: "数据模拟,仅为测试",
                    left: 'center',
                    top: 20,
                    textStyle:{
                        color: 'red',
                        fontSize: 20
                    },
                    subtextStyle:{
                        color: 'white',
                        fontSize: 16
                    }
                },
                timeline: {
                    autoPlay:true,
                    data: ["7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"],
                    axisType: 'category',
                    padding: [5,5,5,5],
                    playInterval:1500,
                    lineStyle:{color:'white'},
                    label:{
                        normal:{
                            textStyle:{
                                color: 'white',
                                fontSize: 13
                            }
                        }
                    }
                },
                bmap: {
                center: [113.331788,23.124235],
                zoom: 16,
                roam: true,
                mapStyle: {
                                styleJson: [
                    {
                            'featureType': 'land',     //调整土地颜色
                            'elementType': 'geometry',
                            'stylers': {
                                        'color': '#081734'
                            }
                    },
                    {
                            'featureType': 'building',   //调整建筑物颜色
                            'elementType': 'geometry',
                            'stylers': {
                                        'color': '#04406F'
                            }
                    },
                    {
                            'featureType': 'building',   //调整建筑物标签是否可视
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'highway',     //调整高速道路颜色
                            'elementType': 'geometry',
                            'stylers': {
                            'color': '#015B99'
                            }
                    },
                    {
                            'featureType': 'highway',    //调整高速名字是否可视
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'arterial',   //调整一些干道颜色
                            'elementType': 'geometry',
                            'stylers': {
                            'color':'#003051'
                            }
                    },
                    {
                            'featureType': 'arterial',
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'green',
                            'elementType': 'geometry',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'water',
                            'elementType': 'geometry',
                            'stylers': {
                                        'color': '#044161'
                            }
                    },
                    {
                            'featureType': 'subway',    //调整地铁颜色
                            'elementType': 'geometry.stroke',
                            'stylers': {
                            'color': '#003051'
                            }
                    },
                    {
                            'featureType': 'subway',
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'railway',
                            'elementType': 'geometry',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'railway',
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'all',     //调整所有的标签的边缘颜色
                            'elementType': 'labels.text.stroke',
                            'stylers': {
                                        'color': '#313131'
                            }
                    },
                    {
                            'featureType': 'all',     //调整所有标签的填充颜色
                            'elementType': 'labels.text.fill',
                            'stylers': {
                                        'color': '#FFFFFF'
                            }
                    },
                    {
                            'featureType': 'manmade',   
                            'elementType': 'geometry',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'manmade',
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'local',
                            'elementType': 'geometry',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'local',
                            'elementType': 'labels',
                            'stylers': {
                            'visibility': 'off'
                            }
                    },
                    {
                            'featureType': 'subway',
                            'elementType': 'geometry',
                            'stylers': {
                                        'lightness': -65
                            }
                    },
                    {
                            'featureType': 'railway',
                            'elementType': 'all',
                            'stylers': {
                                        'lightness': -40
                            }
                    },
                    {
                            'featureType': 'boundary',
                            'elementType': 'geometry',
                            'stylers': {
                                        'color': '#8b8787',
                                        'weight': '1',
                                        'lightness': -29
                            }
                    }]
                }
                },
                visualMap: {
                    min: 0,
                    max: 500,
                    splitNumber: 5,
                    inRange: {
                        color: ['blue', 'green', 'yellow', 'red']
                    },
                    textStyle: {
                        color: '#fff'
                    },
                    bottom: 30
                },
                series: [{
                    type: 'heatmap',
                    mapType: 'china',
                    coordinateSystem: 'bmap',
                    blurSize:50
                }]
            },
            options: [
                {
                    series:[{
                        data : convertData(value,100)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,200)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,300)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,400)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,500)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,600)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,900)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,700)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,600)
                    }]
                },
                {
                    series:[{
                        data : convertData(value,500)
                    }]
                },
                {
                    series:[{
                        data: convertData(value,300)
                    }]
                }
            ]
        }
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        // $.get('', function (data) {

        //     var points = [].concat.apply([], data.map(function (track) {
        //         return track.map(function (seg) {
        //             return seg.coord.concat([1]);
        //         });
        //     }));
        //     console.log(points);
        //     var myChart = echarts.init(element);
        //     myChart.setOption(option = {
        //         animation: false,
        //         bmap: {
        //             center: [120.13066322374, 30.240018034923],
        //             zoom: 14,
        //             roam: true,
        //             mapStyle: {
        //                     styleJson: [
        //                 {
        //                     'featureType': 'land',     //调整土地颜色
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                             'color': '#081734'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'building',   //调整建筑物颜色
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                             'color': '#04406F'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'building',   //调整建筑物标签是否可视
        //                     'elementType': 'labels',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'highway',     //调整高速道路颜色
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                     'color': '#015B99'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'highway',    //调整高速名字是否可视
        //                     'elementType': 'labels',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'arterial',   //调整一些干道颜色
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                     'color':'#003051'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'arterial',
        //                     'elementType': 'labels',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'green',
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'water',
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                             'color': '#044161'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'subway',    //调整地铁颜色
        //                     'elementType': 'geometry.stroke',
        //                     'stylers': {
        //                     'color': '#003051'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'subway',
        //                     'elementType': 'labels',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'railway',
        //                     'elementType': 'geometry',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'railway',
        //                     'elementType': 'labels',
        //                     'stylers': {
        //                     'visibility': 'off'
        //                     }
        //                 },
        //                 {
        //                     'featureType': 'all',     //调整所有的标签的边缘颜色
        //                     'elementType': 'labels.text.stroke',
        //                     'stylers': {
        //                             'color': '#313131'
        //                     }
        //                 },
        //                 {
        //                             'featureType': 'all',     //调整所有标签的填充颜色
        //                             'elementType': 'labels.text.fill',
        //                             'stylers': {
        //                                     'color': '#FFFFFF'
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'manmade',   
        //                             'elementType': 'geometry',
        //                             'stylers': {
        //                             'visibility': 'off'
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'manmade',
        //                             'elementType': 'labels',
        //                             'stylers': {
        //                             'visibility': 'off'
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'local',
        //                             'elementType': 'geometry',
        //                             'stylers': {
        //                             'visibility': 'off'
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'local',
        //                             'elementType': 'labels',
        //                             'stylers': {
        //                             'visibility': 'off'
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'subway',
        //                             'elementType': 'geometry',
        //                             'stylers': {
        //                                     'lightness': -65
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'railway',
        //                             'elementType': 'all',
        //                             'stylers': {
        //                                     'lightness': -40
        //                             }
        //                 },
        //                 {
        //                             'featureType': 'boundary',
        //                             'elementType': 'geometry',
        //                             'stylers': {
        //                                     'color': '#8b8787',
        //                                     'weight': '1',
        //                                     'lightness': -29
        //                             }
        //                 }]
        //                 }
        //         },
        //         visualMap: {
        //             show: false,
        //             top: 'top',
        //             min: 0,
        //             max: 5,
        //             seriesIndex: 0,
        //             calculable: true,
        //             inRange: {
        //                 color: ['blue', 'blue', 'green', 'yellow', 'red']
        //             }
        //         },
        //         series: [{
        //             type: 'heatmap',
        //             coordinateSystem: 'bmap',
        //             data: points,
        //             pointSize: 5,
        //             blurSize: 6
        //         }]
        //     });
        //     // 添加百度地图插件
        //     var bmap = myChart.getModel().getComponent('bmap').getBMap();
        //     bmap.addControl(new BMap.MapTypeControl());
        // });

        // var myChart = echarts.init(element);
        // myChart.setOption({
        //     bmap: {
        //         center: [116.358359,27.99347],  //中心视角的坐标
        //         zoom: 18,       //缩放级别
        //         roam: true    //是否可以缩放
                
        //     },
        //     visualMap: {
        //         show: false,
        //         top: 'top',
        //         min: 0,
        //         max: 5,
        //         seriesIndex: 0,
        //         calculable: true,
        //         inRange: {
        //             color: ['blue', 'blue', 'green', 'yellow', 'red']
        //         }
        //     },
        //     // timeline: {
        //     //     autoPlay:true,
        //     //     data: ["7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"],
        //     //     axisType: 'category',
        //     //     padding: [5,5,5,5],
        //     //     playInterval:1500,
        //     //     lineStyle:{color:'white'},
        //     //     label:{
        //     //         normal:{
        //     //             textStyle:{
        //     //                 color: 'white',
        //     //                 fontSize: 13
        //     //             }
        //     //         }
        //     //     }
        //     // },
        //     series: [{
        //         type: 'heatmap',
        //         coordinateSystem: 'bmap',
        //         data: secRing,
        //         pointSize: 5,
        //         blurSize: 6
        //     }]


        // });

        // var bmap = myChart.getModel().getComponent('bmap').getBMap();
        // bmap.addControl(new BMap.MapTypeControl());
        // bmap.setCurrentCity('抚州');

        // //创建经纬度数组
        // var secRing = [
        //     [116.357349,27.99969],
        //     [116.358481,27.999562],
        //     [116.358355,27.99894],
        //     [116.358606,27.998494],
        //     [116.35866,27.99784],
        //     [116.35866,27.99784],
        //     [116.359127,27.997313],
        //     [116.35981,27.996436],
        //     [116.360232,27.995543],
        //     [116.360232,27.995543],
        //     [116.360699,27.994443],
        //     [116.361242,27.993981],
        //     [116.362209,27.992784],
        //     [116.361238,27.991779],
        //     [116.358552,27.991349],
        //     [116.355651,27.991221],
        //     [116.354411,27.991835],
        //     [116.356046,27.996779]
        // ];
    }
}

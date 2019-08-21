var songsList = null;
var myPlaylist = null;
var json = null;


$(document).ready(function(){

  // songsList = [
  //   {
  //     title:"儿歌1",
  //     artist:"隔壁老王",
  //     mp3:"./content/songs/儿歌.mp3",
  //     poster: "./content/songs/儿歌.jpg"
  //   },
  //   {
  //     title:"儿歌2",
  //     artist:"隔壁老王",
  //     mp3:"./content/songs/儿歌.mp3",
  //     poster: "./content/songs/儿歌.jpg"
  //   },
  //   {
  //     title:"儿歌3",
  //     artist:"隔壁老王",
  //     mp3:"./content/songs/儿歌.mp3",
  //     poster: "./content/songs/儿歌.jpg"
  //   }
  // ];
  // initJPlayer(songsList);

  $.get("/getMusic", function(data){
      json = JSON.stringify(data);
      songsList = JSON.parse(json);
      initJPlayer(songsList);
      // alert(json);
    });

  $(document).on('click', '#addTab', function(e){
    var id = $("#hidInp").val();
    $.get("/playMusic/"+id, function(data){
      json = JSON.stringify(data);
      songsList = JSON.parse(json);
      initJPlayer(songsList);
    });
  });

  $("#jplayer_N").jPlayer({
    ready: function () {
      $(this).jPlayer("setMedia",songsList).jPlayer("play")//自动播放
    },
    swfPath: "js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",

    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false
  }).jPlayer("play").jPlayer("repeat");//自动播放 自动循环

  myPlaylist = new jPlayerPlaylist({
    jPlayer: "#jplayer_N",
    cssSelectorAncestor: "#jp_container_N"
  }, songsList, {
    playlistOptions: {
      enableRemoveControls: true,
      autoPlay: true
    },
    swfPath: "js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",
    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false
  });
});

function initJPlayer(songsList){
  myPlaylist.setPlaylist(songsList);
  $("#jplayer_N").jPlayer("clearMedia");

  $("#jplayer_N").jPlayer("load");
  $("#jplayer_N").jPlayer("play");

  $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').removeClass('animate');
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  });

  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').addClass('animate');
  });

  $(document).on('click', '.jp-play-me', function(e){
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    $('.jp-play-me').not($this).removeClass('active');
    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

    $this.toggleClass('active');
    $this.parent('li').toggleClass('active');
    if( !$this.hasClass('active') ){
      myPlaylist.pause();
    }else{
      var i = Math.floor(Math.random() * (1 + 7 - 1));
      myPlaylist.play(i);
    }
  });
}
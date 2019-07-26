<!DOCTYPE html>
<!--[if IE 8 ]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>register</title>


<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<![endif]-->

<link href="css/normalize.css" rel="stylesheet"/>
<link href="css/jquery-ui.css" rel="stylesheet"/>
<link href="css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>

<style type="text/css">
body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
#my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}
#comments{width:350px;height:100px;}
</style>

</head>
<body>


<div class="row">

  <div class="eightcol last">

    <!-- Begin Form -->

    <form id="my-form" method="post" action="./Register3p">		

        <section name="Step 1">
		
          <div>
            <label>Username:</label><input id="username" name="username" type="text"/></div>
          <div><label>Password:</label><input id="pass" name="password" type="password"/></div>
          <div><label>Address:</label><input id="email" name="email" data-ideal="" type="email"/></div>
          <div>
          <div><label>Birthday:</label><input name="date" class="datepicker" data-ideal="date" type="text" placeholder="月/日/年"/></div>
          <div><label>Upload Avatar:</label><input id="file" name="file" multiple type="file"/></div>
          <div><label>Email:</label><input name="website" data-ideal="url" type="text"/></div>
        </section>

        <section name="Step 2">
          <div>
            <label>Real name:</label>
            <input id="realname" name="realname" type="text"/></div>
          
          
          <div><label>Age:</label>
            <label><input type="radio" name="radio" checked/>5-13</label>
            <label><input type="radio" name="radio"/>14-20</label>
            <label><input type="radio" name="radio"/>21-30</label>
            <label><input type="radio" name="radio"/>31~</label>
          </div>
        </section>

        <section name="Step 3">
          <div><label>Phone�:</label><input type="text" name="phone" /></div>
          <div><label>Nationality:</label>
          <select id="states" name="states">
            <option value="default">&ndash;Select Nationality &ndash;</option>
            <option value="AL">Abra</option>
            <option value="AK">China</option>
            <option value="AZ">America</option>
            <option value="AR">France</option>
            <option value="CA">England</option>
            <option value="CO">German</option>
            <option value="CT">Spain��</option>
            <option value="DE">Russia</option>
          </select>
        </div>
        <div><label>邮编:</label><input type="text" name="zip" data-ideal="zip"/></div>
        <div>
          <label>Introduction:</label><textarea id="comments" name="comments"></textarea></div>
      </section>

      <div><hr/></div>

      <div>
      	<form action="./Register3p.jsp">
      	<input type="SUBMIT" name="submit" value="Submit">
        <input type="button" value="Reset" name="reset" onClick="window.location.href('./Register3p.jsp')" />
        <input type="button" value="Back" name="reset" onClick="window.location.href('./demo1.jsp')" />
        </form>
      </div>

    </form>

    <!-- End Form -->

  </div>

</div>


<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>
<script type="text/javascript">
var options = {

	onFail: function(){
		alert( $myform.getInvalid().length +' invalid fields.' )
	},

	inputs: {
		'password': {
			filters: 'required pass',
		},
		'username': {
			filters: 'required username',
			data: {
			//ajax: { url:'validate.php' }
			}
		},
		'file': {
			filters: 'extension',
			data: { extension: ['jpg'] }
		},
		'comments': {
			filters: 'min max',
			data: { min: 50, max: 200 }
		},
		'states': {
			filters: 'exclude',
			data: { exclude: ['default'] },
			errors : {
				exclude: '选择国籍.'
			}
		},
		'langs[]': {
			filters: 'min max',
			data: { min: 2, max: 3 },
			errors: {
				min: 'Check at least <strong>2</strong> options.',
				max: 'No more than <strong>3</strong> options allowed.'
			}
		}
	}
	
};

var $myform = $('#my-form').idealforms(options).data('idealforms');

$('#reset').click(function(){
	$myform.reset().fresh().focusFirst()
});

$myform.focusFirst();
</script>
<div style="text-align:center;">

</div>
</body>
</html>
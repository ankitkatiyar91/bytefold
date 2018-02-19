<?php
	$uploadedImages=false;
// check if form was submitted
if(isset($_POST['submit']))
{
	$imagesUpdated[]=array();
	$imageNamePrefix="new_";
	// directory where you want to keep files
	$fileDirectory="images/";
	// Look for files and upload them to images folder
	if(sizeof($_FILES)!=0){
		$counter=0;
		foreach($_FILES as $key => $image_data)
		{
			if($image_data['error']==0)
			{
				//echo "image $counter is valid temp path : ".$image_data['tmp_name']." actual path: images/".$image_data['name'];
				//generate a unique file name
				$fileName = $imageNamePrefix . ($counter+1).'_'.$image_data['name'];
				$uploaded = move_uploaded_file($image_data['tmp_name'], $fileDirectory.$fileName);
				if($uploaded){
					$imagesUpdated[$counter]=$fileName;
				}else{
					$imagesUpdated[$counter]=null;
				}
			}
			$counter++;
		}
	}
}
?>

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>php File Upload</title>
	<!-- Bootstrap Core CSS -->
	<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- MetisMenu CSS -->
	<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
	<!-- Custom CSS -->
	<link href="../dist/css/sb-admin-2.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- php5 Shim and Respond.js IE8 support of php5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/php5shiv/3.7.0/php5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">ADD Information</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<?php 
				if($uploadedImages){
			?>
				<div class="col-lg-12">
					<div class="alert alert-primary" role="alert">
					  Updated Successfully.
					</div>
				</div>
			<?php } ?>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							Add Information For New Arrival Page.
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<form  method="post" enctype="multipart/form-data">
										<?php
											for($i=1;$i<=2;$i++){ 
										?>
											<div class="form-group">
												<label>File input for image <?=$i?></label>
												<input style="margin-top:30px" id="image<?=$i?>" name="image<?=$i?>" multiple="multiple" type="file" />
											</div>
										<?php } ?>
                                    <div class="form-group">
                                    	<div class="col-sm-offset-2 col-sm-10">
                                    		<button type="submit" name="submit" class="btn btn-primary">Submit</button>
                                    	</div>
                                    </div>
                                </form>


                            </div>
                        </div>
                    </div>

                    <!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

</body>

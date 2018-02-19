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
	<meta name="description" content="bytefold.com">
	<meta name="author" content="bytefold">
	<title>php File Upload</title>

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
</body>

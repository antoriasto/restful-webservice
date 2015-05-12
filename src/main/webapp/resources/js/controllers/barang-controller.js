angular.module('barang.controller', ['barang.service']).controller('BarangController', ['$scope', 'BarangService',
function($scope, BarangService) {

	$scope.refresh = function() {
		BarangService.query().success(function(data) {
			$scope.barangList = data;
		});
	};

	$scope.refresh();
	$scope.barang = null;

	$scope.baru = function() {
		$scope.barang = null;
		$('#dialogBarang').modal('hide');
	};

	$scope.simpan = function() {

		var obj = $scope.barang;
		if (obj != null) {
			BarangService.save($scope.barang).success(function() {
				alert('Data Berhasil Disimpan');
				$scope.refresh();
				$scope.baru();
			});
		}

	};

}]); 
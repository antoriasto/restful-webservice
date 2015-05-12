angular.module('barang.service', ['ngResource']).factory('BarangService', ['$resource', '$http',
function($resource, $http) {
	var service = {
		barang : $resource('barang/:id'),
		get : function(param, callback) {
			return this.barang.get(param, callback);
		},
		save : function(obj) {
			if (obj.id == null) {
				return $http.post('barang/new', obj);
			} else {
				return $http.put('barang/edit/' + obj.id, obj);
			}
		},
		query : function() {
			return $http.get('barang/list');
		},
		remove : function(obj) {
			if (obj.id != null) {
				return $http.delete('barang/remove/' + obj.id);
			}
		}
	};

	return service;

}]); 
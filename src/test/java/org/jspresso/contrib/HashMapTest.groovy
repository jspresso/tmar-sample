package org.jspresso.contrib

import java.util.Map
import org.jspresso.contrib.tmar.core.Tmar

class HashMapTest extends Tmar {


	def getTest() {

		when:
		// load the map using the "sample 1" table
		Map map = new HashMap()
		def i = 0;
		while (i < tmar.getTableSize('sample1')) {
			def k = tmar.getTableValue("sample1", i, "key")
			def v = tmar.getTableValue("sample1", i, "value")
			map.put(k, v)
			i++
		}

		// Prepare assertions
		tmar.expectedValue = map.get(tmar.key);

		then:
		tmar.asserts()

		where:
		tmar << getData('getTest')
	}



	def putTest() {

		when:
		Map map = new HashMap()

		while (tmar.hasNext()) {

			switch (tmar.operation) {

				case 'put' :

					map.put(tmar.key, tmar.value)
					tmar.size = map.size()
					break;

				case 'get' :

					tmar.expectedValue = map.get(tmar.key)
					break;

				case 'contains' :

					tmar.expectedValue = map.containsKey(tmar.key)
					break;

				default :
					tmar.size = map.size()
					break;
			}
		}

		//-------
		then:
		tmar.asserts()

		//-------
		cleanup:
		// Cleanup your data
		// TODO If necessary !

		//-------
		where:
		tmar << getData('putTest')
	}


}

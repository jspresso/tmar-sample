package org.jspresso.contrib.sample.junit

import org.junit.runners.JUnit4

import java.util.Map

import org.jspresso.contrib.tmar.core.Tmar4JUnit;
import org.junit.Test;

class HashMapTest extends Tmar4JUnit {

	@Test
	void getTest() {

		def tmarData = getData('getTest')
		// define nbrLine using the "sample 1" table size
		int nbrLine = tmarData.getTableSize('sample1')

		eachIteration(tmarData) { tmar ->
			// load the map using the "sample 1" table
			Map map = new HashMap()
			def i = 0;
			while (i < nbrLine ) {
				def k = tmar.getTableValue("sample1", i, "key")
				def v = tmar.getTableValue("sample1", i, "value")
				map.put(k, v)
				i++
			}

			tmar.expectedValue = map.get(tmar.key)
		}
	}

  
  
	void putTest() {

		Map map = new HashMap()

		eachIteration('putTest') { tmar ->

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
	}
}

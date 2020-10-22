/*******************************************************************************
 * Copyright 2019 Observational Health Data Sciences and Informatics
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.ohdsi.usagi;

import java.util.ArrayList;
import java.util.List;

import org.ohdsi.utilities.files.Row;
import org.ohdsi.utilities.files.WriteCSVFileWithHeader;

/**
 * Class for writing code mappings (source codes and mapped target concept(s)) to a CSV file.
 */
public class WriteCodeMappingsToFile {
	private WriteCSVFileWithHeader out;

	public WriteCodeMappingsToFile(String filename) {
		out = new WriteCSVFileWithHeader(filename);
	}

	public void write(CodeMapping codeMapping) {
		List<MappingTarget> mappingTargets;
		if (codeMapping.targetConcepts.size() == 0) {
			mappingTargets = new ArrayList<>(1);
			mappingTargets.add(new MappingTarget());
		} else
			mappingTargets = codeMapping.targetConcepts;
		for (MappingTarget targetConcept : mappingTargets) {
			Row row = codeMapping.sourceCode.toRow();
			row.add("matchScore", codeMapping.matchScore);
			row.add("mappingStatus", codeMapping.mappingStatus.toString());
			row.add("statusSetBy", codeMapping.statusSetBy);
			row.add("statusSetOn", codeMapping.statusSetOn);
			row.add("conceptId", targetConcept.concept.conceptId);
			row.add("mappingType", targetConcept.mappingType.toString());
			row.add("comment", codeMapping.comment);
			row.add("createdBy", targetConcept.createdBy);
			row.add("createdOn", targetConcept.createdOn);
			out.write(row);
		}
	}

	public void close() {
		out.close();
	}
}

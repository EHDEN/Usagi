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
package org.ohdsi.usagi.ui;

public interface DataChangeListener {

	public static DataChangeEvent	APPROVE_EVENT		= new DataChangeEvent(true, false, false);
	public static DataChangeEvent	SIMPLE_UPDATE_EVENT	= new DataChangeEvent(false, false, false);
	public static DataChangeEvent	MULTI_UPDATE_EVENT	= new DataChangeEvent(false, false, true);
	public static DataChangeEvent	RESTRUCTURE_EVENT	= new DataChangeEvent(false, true, false);

	public void dataChanged(DataChangeEvent event);

	public static class DataChangeEvent {
		public DataChangeEvent(boolean approved, boolean structureChange, boolean multiUpdate) {
			this.approved = approved;
			this.structureChange = structureChange;
			this.multiUpdate = multiUpdate;
		}

		public boolean	approved		= false;
		public boolean	structureChange	= false;
		public boolean	multiUpdate	= false;
	}
}

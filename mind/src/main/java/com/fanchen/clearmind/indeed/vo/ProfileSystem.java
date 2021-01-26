package com.fanchen.clearmind.indeed.vo;

import java.util.HashMap;
import java.util.Map;

public class ProfileSystem {
	
	// divde and conquery upload
	// metadata as index of each chunk
	// 1.indexer, chunker, watcher, db
	// 2, messaging service: rabbitMq, kafka
	// 3. sync service
	// 4. cache, DB
	// 5. machine learning techs to put server at the populated area
	
	
	
	// Bandwidth and cloud space utilization
	// Latency or Concurrency utilization

	class Profile {
		int version;
		String id;
		Map<Integer, Map<String, String>> versionMap;

		public Profile(String id) {
			this.id = id;
			this.version = 1;
			versionMap = new HashMap<>();
			versionMap.put(1, new HashMap<>());
		}
	}

	Map<String, Profile> profiles;

	public ProfileSystem() {
		profiles = new HashMap<>();
	}

	public void update(String profileId, String field, String value) {
		Profile curProfile = profiles.get(profileId);
		if (curProfile == null) {
			// create profile
			Profile newProfile = new Profile(profileId);
			newProfile.versionMap.get(newProfile.version).put(field, value);
			profiles.put(profileId, newProfile);
		} else {
			// update the field
			Map<String, String> attributes = curProfile.versionMap.get(curProfile.version);
			if (attributes.containsKey(field)) {
				curProfile.version++;
				curProfile.versionMap.put(curProfile.version, new HashMap<>(attributes));
				curProfile.versionMap.get(curProfile.version).put(field, value);

			} else {
				attributes.put(field, value);
			}
		}
	}

	public String get(String profileId, int version) {
		Profile curProfile = profiles.get(profileId);
		if (curProfile == null) {
			return null;
		}
		Map<String, String> attributes = curProfile.versionMap.get(curProfile.version);
		StringBuilder sb = new StringBuilder();
		sb.append("{\"" + profileId + "\": ");
		for (String field : attributes.keySet()) {
			sb.append("\"" + field + "\": " + "\"" + attributes.get(field) + "\",");
		}
		sb.append("}");
		return sb.toString();
	}

	public String getField(String profileId, int version, String field) {
		Profile curProfile = profiles.get(profileId);
		if (curProfile == null || curProfile.versionMap.containsKey(version)) {
			return null;
		}
		return curProfile.versionMap.get(version).get(field);

	}
}

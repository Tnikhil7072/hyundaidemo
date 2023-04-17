package com.hyundai.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author T Nikhil
 * <p>
 * This model class  is used to get the dynamic drop down on the page,
 */

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class DynamicDropModel {
	
	private final Logger LOG = LoggerFactory.getLogger(DynamicDropModel.class);

	@Inject
	private ResourceResolver resourceResolver;

	private List<State> state;
	
	/**
	 * we have an if statement that checks to see if there are any states defined in our @ValueMapValue annotation.
	 */

	@ValueMapValue(name = "states")
	private String[] stateArray;
	
	/**
	 * The last line declares a PostConstruct method which runs after this class has been initialized (which means before anything else).
	 */
	
	@PostConstruct
	protected void init() {
		state = new ArrayList<>();
		/**
		 *  This code starts by logging the string "inside initi" to the console.

		 */
		LOG.debug("\n inside initi =======================Excutive=======================");
		
		/**
		 *  It then logs a debug message that says, "inside get ArrayList."

		 */
		LOG.debug("inside get ArrayList");
		Resource resource = resourceResolver.getResource("/content/hyundaidemo/us/en/state-dropdown-on-page/jcr:content/states");
		
		/**
		 *  this code gets a resource from the resolver and prints out its path.

		 */
		LOG.debug("paht is : " + resource.getPath());
		if (resource != null) {
			LOG.debug("\n resource =======================Excutive=======================");
			/**
			 * This code is used to iterate through the children of a resource and print out the state name.
			 */
			Iterable<Resource> children = resource.getChildren();
			LOG.debug("\n childresource =======================Excutive=======================");
			for (Resource child : children) {
				State currentState = new State();
				LOG.debug("\n currentState =======================Excutive=======================");
				/**
				 *  This code prints out the current state name and value map.

				 */
				ValueMap values = child.getValueMap();
				LOG.debug("values.get(\"code\").toString() is : " + values.get("code").toString());
				LOG.debug("values.get(\"code\").toString() is : " + values.get("name").toString()); 
				
				/**
				 *  The code starts by creating a new variable called currentState.

				 */
				
				currentState.setLabel(values.get("code").toString());
				currentState.setValue(values.get("name").toString());
				
				/**
				 *  Next, it adds this state to the list of states in state.

				 */
				state.add(currentState);
				LOG.debug("inside initi method : state is :::: " + state.toString());
			}
		}
	}

	public List<State> getState() {
		LOG.debug("\n getState=======================Excutive ======================");
		LOG.debug("inside getstates method : state is : " + state.toString());
		return state;
	}


}

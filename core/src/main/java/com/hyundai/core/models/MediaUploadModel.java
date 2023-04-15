package com.hyundai.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


/**
 * @author T Nikhil
 * <p>
 * This model is used for which can support both Image and Video, using file upload 
   field and render it on the page,
 */

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MediaUploadModel {

	@Inject
	private String fileReference;

	@Inject
	private String mediaFile;
	

	public String getFileReference() {
		return fileReference;
	}

	public String getMediaFile() {
		return mediaFile;
	}

}

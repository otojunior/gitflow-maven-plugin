/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.org.otojunior.plugin.gitflow;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.lib.Ref;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Mojo(name="feature-start")
public class FeatureStartMojo extends AbstractMojo {
	/**
	 * Feature name.
	 */
	@Parameter(property="feature.name", required=true)
	private String featureName;
	
	/**
	 * Feature name.
	 */
	@Parameter(property="feature.version", required=true)
	private String featureVersion;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		checkoutNewFeatureBranch();
		updatePomVersion();
		commitChanges();
	}
	
	/**
	 * 
	 */
	private void commitChanges() {
		getLog().info("commitChanges() ainda não implementado");
	}

	/**
	 * 
	 */
	private void updatePomVersion() {
		getLog().info("updatePomVersion() ainda não implementado");
	}

	/**
	 * 
	 * @throws MojoExecutionException
	 */
	private void checkoutNewFeatureBranch() throws MojoExecutionException {
		try {
			Ref ref = Git.open(new File(".git")).
				checkout().
				setCreateBranch(true).
				setName(featureName).
				call();
			getLog().info(ref.toString());
		} catch (GitAPIException | IOException e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}
	}
}

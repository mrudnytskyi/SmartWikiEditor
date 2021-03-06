/*
 * Copyright (C) 2015 Myroslav Rudnytskyi
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 */

package intelligent.wiki.editor.core.sweble;

import intelligent.wiki.editor.core.SimpleMarkup;
import intelligent.wiki.editor.core_api.ASTNode;
import intelligent.wiki.editor.core_api.Parser;
import intelligent.wiki.editor.core_impl.sweble.SwebleASTNode;
import intelligent.wiki.editor.core_impl.sweble.SwebleParser;
import intelligent.wiki.editor.spring.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Class for testing {@link SwebleParser} class.
 *
 * @author Myroslav Rudnytskyi
 * @version 11.11.2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class SwebleParserTest {

	@Inject
	private Parser parser;

	@Test
	public void testParseSimpleArticle() throws Exception {
		ASTNode article = parser.parse(new SimpleMarkup());
		Assert.assertEquals(true, article != null);
		Assert.assertEquals(SwebleASTNode.class, article.getClass());
	}

	@Test(expected = Parser.ParserException.class)
	public void testParseNullArticle() throws Exception {
		parser.parse(null);
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}
}
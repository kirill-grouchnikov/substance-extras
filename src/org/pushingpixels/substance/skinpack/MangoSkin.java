/*
 * Copyright (c) 2005-2010 Substance Kirill Grouchnikov. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer. 
 *     
 *  o Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *     
 *  o Neither the name of Substance Kirill Grouchnikov nor the names of 
 *    its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.pushingpixels.substance.skinpack;

import java.awt.Color;

import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.colorscheme.*;
import org.pushingpixels.substance.api.painter.border.ClassicBorderPainter;
import org.pushingpixels.substance.api.painter.decoration.Glass3DDecorationPainter;
import org.pushingpixels.substance.api.painter.fill.StandardFillPainter;
import org.pushingpixels.substance.api.painter.highlight.ClassicHighlightPainter;
import org.pushingpixels.substance.api.shaper.ClassicButtonShaper;
import org.pushingpixels.substance.colorschemepack.MixColorScheme;
import org.pushingpixels.substance.internal.colorscheme.BlendBiColorScheme;
import org.pushingpixels.substance.internal.colorscheme.SaturatedColorScheme;
import org.pushingpixels.substance.painterpack.fill.MixDelegateFillPainter;
import org.pushingpixels.substance.watermarkpack.SubstanceMarbleVeinWatermark;

/**
 * <code>Mango</code> skin. This class is part of officially supported API.
 * 
 * @author Kirill Grouchnikov
 * @since version 3.1
 */
public class MangoSkin extends SubstanceSkin {
	/**
	 * Display name for <code>this</code> skin.
	 */
	public static final String NAME = "Mango";

	/**
	 * Creates a new <code>Mango</code> skin.
	 */
	public MangoSkin() {
		SubstanceColorScheme activeScheme = new MixColorScheme("Mango Active",
				new SunGlareColorScheme(), new BarbyPinkColorScheme())
				.saturate(0.2);
		SubstanceColorScheme defaultScheme = new BlendBiColorScheme(
				new AquaColorScheme(), new LimeGreenColorScheme(), 0.5).tone(
				0.1).saturate(-0.2);

		SubstanceColorScheme disabledScheme = new SaturatedColorScheme(
				defaultScheme, -0.3) {
			Color foreColor = new Color(91, 165, 129);

			@Override
			public Color getForegroundColor() {
				return foreColor;
			}
		};
		SubstanceColorSchemeBundle defaultSchemeBundle = new SubstanceColorSchemeBundle(
				activeScheme, defaultScheme, disabledScheme);
		this.registerDecorationAreaSchemeBundle(defaultSchemeBundle,
				DecorationAreaType.NONE);

		this.buttonShaper = new ClassicButtonShaper();
		this.watermark = new SubstanceMarbleVeinWatermark();
		this.borderPainter = new ClassicBorderPainter();
		this.highlightPainter = new ClassicHighlightPainter();
		this.fillPainter = new MixDelegateFillPainter("Mixed Standard",
				new StandardFillPainter());
		this.decorationPainter = new Glass3DDecorationPainter();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.pushingpixels.substance.skin.SubstanceSkin#getDisplayName()
	 */
	public String getDisplayName() {
		return NAME;
	}
}

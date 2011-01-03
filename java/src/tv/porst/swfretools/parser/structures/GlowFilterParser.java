package tv.porst.swfretools.parser.structures;

import tv.porst.splib.io.BinaryParser;
import tv.porst.splib.io.Flag;

public class GlowFilterParser {

	public static GlowFilter parse(final BinaryParser parser) {
		final RGBA glowColor = RGBAParser.parse(parser);
		final Fixed blurX = FixedParser.parse(parser);
		final Fixed blurY = FixedParser.parse(parser);
		final Fixed8 strength = Fixed8Parser.parse(parser);
		final Flag innerShadow = parser.readFlag();
		final Flag knockout = parser.readFlag();
		final Flag compositeSource = parser.readFlag();
		final int passes = parser.readBits(5);

		return new GlowFilter(glowColor, blurX, blurY, strength, innerShadow, knockout, compositeSource, passes);
	}

}

require_relative './storm'

class RubyBolt < Storm::Bolt
  def process(tuple)
    puts "FROM RUBY: #{tuple.values.first}"
  end
end

RubyBolt.new.run
